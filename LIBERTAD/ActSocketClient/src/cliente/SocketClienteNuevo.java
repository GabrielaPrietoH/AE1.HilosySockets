package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SocketClienteNuevo {

    public static final int PUERTO = 2017;
    public static final String IP_SERVER = "localhost"; // localhost = mi equipo

    public static void main(String[] args) {

        try {
            // Quiero tener la direccion del servidor al que me voy a conectar
            // de una forma segura
            InetSocketAddress serverDir = new InetSocketAddress(IP_SERVER, PUERTO);

            // Conexión que queremos para el servidor
            Socket socket = new Socket();

            // Nos conectamos contra el servidor
            socket.connect(serverDir);
            System.out.println("Nos hemos conectado contra el servidor!");

            PrintStream mensajesHaciaElServidor = new PrintStream(socket.getOutputStream());
            InputStreamReader mensajesDesdeElServidor = new InputStreamReader(socket.getInputStream());
            BufferedReader buffer = new BufferedReader(mensajesDesdeElServidor);

            boolean salir = false;
            Scanner scanner = new Scanner(System.in);
            int choice;

            while (!salir) {

                // ----- Menu -----

                System.out.println("Menú:");
                System.out.println("1. Consultar película por ID");
                System.out.println("2. Consultar película por título");
                System.out.println("3. Salir de la aplicación");
                System.out.print("Elija una opción: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Introduzca el ID de la película: ");
                        int movieID = scanner.nextInt();
                        scanner.nextLine(); // Limpia el buffer de entrada
                        System.out.println("Consultando película por ID: " + movieID);
                        mensajesHaciaElServidor.println(choice + "-" + movieID);
                        System.out.println(buffer.readLine());
                        break;
                    case 2:
                        System.out.print("Introduzca el título de la película: ");
                        scanner.nextLine();
                        String movieTitle = scanner.nextLine();
                        System.out.println("Consultando película por título: " + movieTitle);
                        mensajesHaciaElServidor.println(choice + "-" + movieTitle);
                        System.out.println(buffer.readLine());
                        break;
                    case 3:
                        mensajesHaciaElServidor.println(choice);
                        System.out.println(buffer.readLine());
                        // Cerramos la conexion
                        salir = true;
                        socket.close();
                        scanner.close();
                        // System.out.println("Hemos cerrado la conexion");
                        System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }


        } catch (Exception e) {
            System.out.println("Excepcion" + e);
        }
    }

}
