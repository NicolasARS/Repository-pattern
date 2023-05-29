package Gym1;

public class GymNetworkService {

    static  final java.sql.Connection connection = DatabaseConnection.getInstance().getConnection();
    public static java.sql.Connection getConnection(){
        return connection;
    }
}
