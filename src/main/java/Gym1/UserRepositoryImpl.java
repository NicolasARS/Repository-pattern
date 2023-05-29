package Gym1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IRepository<User> {
    private List<User> entities = new ArrayList<>();
    private java.sql.Connection con;
    public UserRepositoryImpl(){
        this.con = GymNetworkService.getConnection();
    }

    /**
     * Se encarga de mapear um registro de la base de datos para converirlo en un objeto User
     * @param rs
     * @return Un objeto User
     * @throws SQLException
     */
    public User bdToEntity(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
    }

    /**
     * Consulta todos los registros de la tabla users
     * @return Una lista de objetos User
     * @throws SQLException
     */
    public List<User> findAll() throws SQLException {

        List<User> users = new ArrayList<>();

        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios ORDER BY apellidos, nombre");

        while(rs.next()){
            //Mapeamos el registro de la BD en un User
            User u =  bdToEntity(rs);
            //Añadir el User al conjunto de users
            users.add(u);
        }
        return users;
    }
    //De momento estos tres métodos no hacen nada pero hacen falta para poder probar findAll
    public User findById(int id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT * FROM usuarios WHERE id = ? ");
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        User u = null;
        //Si la consulta devuelve algún resultado ...
        if (rs.next()){
            // ... lo mapeamos a un objeto Usuario
            u = bdToEntity(rs);
        }
        //Devolvemos el Usuario ya mapeado
        return u;
    }

    public void save(User user) throws SQLException{
        if (user.getId() == -1){
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO usuarios (nombre, apellidos) VALUES (?, ?)";
            //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, user.getName());
            st.setString(2, user.getLastName());

            st.executeUpdate();

            //Recuperar el id autogenerado
            rs = st.getGeneratedKeys();
            //Este ResultSet solo puede contener un registro: el ID autogenerado

            if (rs.next()){
                //Ahora ya sabemos cuál es el nuevo id del Usuario
                user.setId(rs.getInt(1));
                System.out.println("Autogenerated ID:  " + user.getId());
            }
        }else{
            PreparedStatement st = con.prepareStatement("UPDATE usuarios SET nombre = ?, apellidos = ? WHERE id = ?");
            st.setString(1, user.getName());
            st.setString(2, user.getLastName());
            st.setInt(3, user.getId());

            st.executeUpdate();
        }

    }

    public void delete(User user) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
        st.setInt(1, user.getId());
        st.executeUpdate();
        st.close();
    }


    public void deleteById(int id) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM usuarios WHERE id = ? ");
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();

    }
}
