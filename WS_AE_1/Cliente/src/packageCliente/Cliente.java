package packageCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Scanner;


/*
 * Clase Cliente
 * 
 * Esta clase contiene la lógica presentada al cliente. Aquí se establece un canal de comunicación con el cliente,
 * mediante un menú interactivo, que conectará directamente, mediante sockets, con los hilos del servidor, para poder
 * acceder a su catálogo de películas.
 * 
 * */
public class Cliente {
	
	public static final int PUERTO = 2018;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		
		System.out.println("Aplicación CLIENTE");
		
		//Se establece la dirección de la conexión con el servidor.
		InetSocketAddress direccionServidor = new InetSocketAddress (IP_SERVER, PUERTO);
		
		/*
		 * Try and Catch. No se introduce aquí el socket como parámetro, ya que 
		 * se pretende qye el cliente se comunique de forma continua con el servidor.
		 * */
		
		try (Scanner sc = new Scanner(System.in);) {
			
			System.out.println("Cliente: esperando a que el servidor acepte");
			
			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServidor);
			
			System.out.println("Cliente: CONEXIÓN ESTABLECIDA " + IP_SERVER + PUERTO);
			System.out.println("");
			
			//Se inicia el Stream de entrada de datos desde el servidor
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader eB = new BufferedReader(entrada);
			
			//Se inicia el Stream de salida de datos hacia el servidor
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			String texto = "";
			boolean continuar = true;
			
			 do {
				System.out.println("Seleccione una de las siguientes opciones:");
				System.out.println("1. Consultar una película por ID");
				System.out.println("2. Consultar una película por título");
				System.out.println("3. Consultar una película por director");
				System.out.println("4. Añadir una película al catálogo");
				System.out.println("5. Salir de la aplicación");
				
				texto = sc.nextLine();				
	
				if(texto.equals("5")) {
					System.out.println( "Has finalizado el programa" + "\n");
					
					continuar = false;
					
				//Caso para consultar películas por ID;
				}else if(texto.equals("1")) {
					//envío elección
					salida.println(texto);
					//recibo elección-listado de películas
					String respuesta = eB.readLine();
					System.out.println("\n");
					System.out.println(respuesta);
					System.out.println("\n");
					
					//pinto nuevo menú para que elija
					System.out.println("Elige entre los siguientes ID de películas para ver su ficha técncia: 1, 2, 3, 4 o 5:");
					String eleccion = sc.nextLine();
					salida.println(eleccion);
					
					//pinto la película elegida.
					System.out.println(respuesta = eB.readLine());
					System.out.println("");
				
				//Caso para consultar películas por Título;	
				}else if (texto.equals("2")) {
					//envío elección
					salida.println(texto);
					//recibo elección-listado de películas
					String respuesta = eB.readLine();
					System.out.println("");
					System.out.println(respuesta);
					System.out.println("");
					
					//pinto nuevo menú para que elija
					System.out.println("Escribe el título de la película que eliges entre el listado que ves en pantalla:");
					String eleccion = sc.nextLine();
					salida.println(eleccion);
					
					//pinto la película elegida.
					System.out.println(respuesta = eB.readLine());
					System.out.println("");
				
					
				//Requerimiento 2: Caso para consultar películas por director;		
				}else if (texto.equals("3")) {
					//envío elección
					salida.println(texto);
					//recibo elección
					String respuesta = eB.readLine();
					
					System.out.println("\n" + respuesta + "\n");
					
					
					//pinto nuevo menú para que elija
					System.out.println("Elige uno de los anteriores directores para ver su filmografía añadida:");
					String eleccion = sc.nextLine();
					salida.println(eleccion);
					
					//**pinto la película elegida.
					String directorPeli = eB.readLine();
					String[] peliculasRecibidas = directorPeli.split("\\|"); 
					
					//Imprimo cada película recibida en el array mediante un for.
					for (String pelicula : peliculasRecibidas) {
					    System.out.println(pelicula);
					}
					
				//Requerimiento 3: Caso para que el usuario pueda añadir una película a la BBDD.
				}else if (texto.equals("4")) {
					//envío elección
					salida.println(texto);
					//recibo elección
					String respuesta = eB.readLine();
					System.out.println("");
					System.out.println(respuesta);
					System.out.println("");
					
					//pinto nuevo menú para que elija
					System.out.println("Añade una película");
					System.out.println("Añade el id:");
					String id = sc.nextLine();
					System.out.println("Añade el nombre de la película:");
					String nombre = sc.nextLine();
					System.out.println("añade el director de la película:");
					String director = sc.nextLine();
					System.out.println("añade su precio");
					String precio = sc.nextLine();
					
					//Envío los atributos de la película en un String separados, para poder trabajar con ellos en el hilo.
					String datosPelicula = id + "|" + nombre + "|" + director + "|" + precio;
					salida.println(datosPelicula);
					
					
					//pinto la película elegida.
					String añadida = eB.readLine();
					System.out.println("Película añadida por el usuario:");
					System.out.println(añadida);	
					
				}		
				
			}while(continuar);
			
		//Se cierra la conexion
		socketAlServidor.close();
		
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la direcci�n" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENTE: Fin del programa");
	}
	
}
