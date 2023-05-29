package NetworkEjercicio;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SocialNetwork {

    public static void main(String[] args) throws SQLException {

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        List<User> userList = userRepository.findAll();
        for (User u : userList){
            System.out.println(u);
        }

        System.out.println("Que quieres hacer ? ");
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("1 - Mostrar usuarios.");
            System.out.println("2 - Agregar usuario. ");
            System.out.println("3 - Modificar usuario. ");
            System.out.println("4 - ELiminar usuario. ");
            System.out.println("5 - Salir.");
            op = sc.nextInt();

            switch (op){
                case 1:
                    UserController.prinAllUsers();
                break;
                case 2:
                    UserController.addUser();
                break;
                case 3:
                    UserController.modifyUser();
                break;
                case 4:
                    UserController.deleteUser();
                break;
                case 5:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida.Intentelo nuevamente.");
            }
        } while (op != 5);

    }
}
