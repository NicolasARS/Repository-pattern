package Gym1;



public class Suscripcion {
    private int id;
    private String tipoSuscripcion;
    private int precio;
    private String fecha;

    public User usuario;


    public Suscripcion()
    {
        this.tipoSuscripcion = "";
        this.precio = -2;
        this.id = -1;
        this.usuario = null;
    }
    public Suscripcion(int id, String tipoSuscripcion, int precio, String fecha, User user){
        this.id = id;
        this.tipoSuscripcion = tipoSuscripcion;
        this.precio = precio;
        this.fecha = fecha;
        this.usuario = user;
    }

    public Suscripcion(int id, String tipo_suscripcion, int precio, String fecha) {
        this.id = id;
        this.tipoSuscripcion = tipoSuscripcion;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTipoSuscripcion(){
        return tipoSuscripcion;
    }
    public void setTipoSuscripcion(String tipoSuscripcion){
        this.tipoSuscripcion = tipoSuscripcion;
    }
    public int getprecio(){
        return precio;
    }
    public void setprecio(int precio){
        this.precio = precio;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public User getUsuario() {
        return usuario;
    }

    @Override
    public String toString(){
        return "ID: " + id + "Usuario: " + usuario + " Tipo Suscripcion: " + tipoSuscripcion + " Precio: " + precio + " Fecha: " + fecha;
    }

}
