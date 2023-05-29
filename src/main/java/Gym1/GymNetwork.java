package Gym1;
import java.sql.SQLException;
import java.util.Scanner;

public class GymNetwork {

    public static void main(String[] args) throws SQLException {


        System.out.println("Que quieres hacer ? ");
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("1 - Mostrar usuarios.");
            System.out.println("2 - Agregar usuario. ");
            System.out.println("3 - Modificar usuario. ");
            System.out.println("4 - Eliminar usuario. ");
            System.out.println("5 - Mostrar suscripciones.");
            System.out.println("6 - Agregar suscripciones. ");
            System.out.println("7 - Modificar suscripciones. ");
            System.out.println("8 - Eliminar suscripcion. ");
            System.out.println("9 - Salir.");
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
                    SuscripcionController.prinAllSuscripciones();
                    break;
                case 6:
                    SuscripcionController.addSuscripcion();
                    break;
                case 7:
                    SuscripcionController.modifySuscripcion();
                    break;
                case 8:
                    SuscripcionController.deleteSuscripcion();
                    break;
                case 9:
                    System.out.println("Hasta luego!.");
                    break;
                default:
                    System.out.println("Opcion no valida.Intentelo nuevamente.");
            }
        } while (op != 9);

    }
}