package Gym1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SuscripcionController {

    /**
     * Imprime por pantalla todos los usuarios
     * @throws SQLException
     */
    public static void prinAllSuscripciones() throws SQLException {

        SuscripcionRepositoryImpl userRepository = new SuscripcionRepositoryImpl();
        List<Suscripcion> suscripciones = userRepository.findAll();
        for (Suscripcion suscripcion : suscripciones){
            System.out.println(suscripciones);
        }

    }
    /**
     * Muestra una interfaz  de usuario para añadir un usuario
     * @throws SQLException
     */
    public static void addSuscripcion() throws SQLException{
        SuscripcionRepositoryImpl suscripcionRepository = new SuscripcionRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID del Usuario: ");
        int idUsuario = sc.nextInt();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = userRepository.findById(idUsuario);

        System.out.print("Tipo suscripcion: ");
        String tipo_suscripcion = sc.nextLine();
        System.out.print("Precio: ");
        int precio = sc.nextInt();
        System.out.println("Fecha: ");
        String fecha = sc.nextLine();


        Suscripcion suscripcion = new Suscripcion(idUsuario, tipo_suscripcion, precio, fecha, user);
        suscripcionRepository.save(suscripcion);
    }

    /**
     * Muestra la UI para modificar un usuario
     * @throws SQLException
     */
    public static void modifySuscripcion() throws SQLException{
        SuscripcionRepositoryImpl suscripcionRepository = new SuscripcionRepositoryImpl();
        prinAllSuscripciones();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Suscripcion id to modify: ");
        int idSuscripcion = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo suscripcion: ");
        String tipo_suscripcion = sc.nextLine();
        System.out.print("New precio: ");
        int precio = sc.nextInt();
        System.out.println("New fecha: ");
        String fecha = sc.nextLine();
        System.out.println("Idusuario: ");
        int idUsuario = sc.nextInt();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = userRepository.findById(idUsuario);


        suscripcionRepository.save(new Suscripcion(idSuscripcion, tipo_suscripcion, precio, fecha, user));
    }

    /**
     * Muestra la UI para borrar un usuario.
     * @throws SQLException
     */
    public static void deleteSuscripcion() throws SQLException{
        SuscripcionRepositoryImpl userRepository = new SuscripcionRepositoryImpl();
        prinAllSuscripciones();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter suscricion id to delete: ");
        Suscripcion suscripcion = userRepository.findById(sc.nextInt());
        userRepository.delete(suscripcion);
    }
}
