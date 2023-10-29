package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HandleClient extends Thread {
    private Socket cliente;
    private InputStreamReader mensajesDesdeElCliente = null;
    private PrintStream mensajesHaciaElCliente = null;
    private BufferedReader buffer = null;
    private Movies movies;

    public HandleClient(Socket cliente, Movies movies) {
        try {
            this.movies = movies;
            this.cliente = cliente;
            this.mensajesDesdeElCliente = new InputStreamReader(cliente.getInputStream());
            this.mensajesHaciaElCliente = new PrintStream(cliente.getOutputStream());

            this.buffer = new BufferedReader(this.mensajesDesdeElCliente);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en construccion" + e);
        }
    }

    @Override
    public void run() {
        System.out.println("Soy un nuevo hilo del cliente ");
        try {
            String comando = this.buffer.readLine();

            String peticion[] = comando.split("-");
            Movie found = null;
            switch (peticion[0]) {
                case "1":
                    found = this.movies.consultarPorID(Integer.parseInt(peticion[1]));
                    if (found != null) {
                        this.mensajesHaciaElCliente.println(found.toString());
                    } else {
                        this.mensajesHaciaElCliente.println("Busqueda sin resultados...");
                    }
                    break;
                case "2":
                    found = this.movies.consultarPorTitulo(peticion[1]);
                    if (found != null) {
                        this.mensajesHaciaElCliente.println(found.toString());
                    } else {
                        this.mensajesHaciaElCliente.println("Busqueda sin resultados...");
                    }
                    break;
                case "3":
                    this.mensajesHaciaElCliente.println("Adios!");
                    break;
                default:
                    this.mensajesHaciaElCliente.println("No existen valores para la consulta");
                    break;
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error con el hilo del cliente " + e);
        }

    }
}
