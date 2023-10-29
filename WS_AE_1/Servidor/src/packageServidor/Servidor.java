package packageServidor;

import java.io.IOException;
import java.net.*;
import java.util.*;

/*
 * Clase Servidor
 * 
 * Clase que controla las peticiones recibidas por los clientes. Conecta con los hilos para crear un socket diferente
 * por cada petición del cliente. Su lógica se ha trasladado al HiloServidor, para que actúen de forma independiente.
 */



public class Servidor {
	
	public static final int PUERTO = 2018;
	
	public static void main(String[] args) {
		
		//Inicialización del servidor, de la conexión con el Cliente y de los hilos.		
		try(ServerSocket servidor = new ServerSocket()){

			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);
			
			System.out.println("S: esperando petición en" + PUERTO);
			
			while(true) {
				Socket socketAlCliente = servidor.accept();
				
				new HiloServidor(socketAlCliente);
			}
			
			
		} catch (IOException e) {
			System.err.println("Servidor: error de I/O");
			e.printStackTrace();
		} catch(Exception e){
			System.err.println("Servidor: error");
			e.printStackTrace();
		}
		
	}
}
