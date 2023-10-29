package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServidorNuevo{
	
	public static final int PUERTO = 2017;

	public static void main(String[] args) throws InterruptedException{

		try {
			//Definimos la direccion en la que vamos a servir
			InetSocketAddress dir = new InetSocketAddress(PUERTO);
			
			//Creamos la conexion 
			ServerSocket socket = new ServerSocket();

			// Defino por donde voy a escuchar a los clientes -> el puerto que está a la escucha
			socket.bind(dir);
			System.out.println("Servidor a la escucha en puerto "+ PUERTO);
			Socket cliente = null;

			Movies movies = new Movies();

			while(true){
				try {
					cliente = socket.accept();
					System.out.println("He aceptado un nuevo cliente"+ cliente.getInetAddress()); 
	
					Thread hiloCliente = new HandleClient(cliente, movies); 
					hiloCliente.start();
					
				} catch (Exception e) {
					cliente.close();
				}
			}


		} catch (Exception e) {
			
			// TODO: handle exception
		}


	}
}

