package packageServidor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HiloServidor implements Runnable {
	
	private Thread hilo;
	private Socket socketAlCliente;
	
	//List<Peliculas> listaDePeliculas = Servidor.obtenerPeliculas();
	private static List<Peliculas> peliculas = new ArrayList<>();
	
	public HiloServidor (Socket socketAlCliente) {
		hilo = new Thread(this);
		this.socketAlCliente = socketAlCliente;
		hilo.start();
	}
	
	private static void addPeliculas() {
		peliculas.add(new Peliculas(1, "Origen", "Christopher Nolan", 10));
		peliculas.add(new Peliculas(2, "El código DaVinci", "Ron Howard", 9));
		peliculas.add(new Peliculas(3, "Harry Potter y el prisionero de Azkaban", "Alfonso Cuarón", 8));
		peliculas.add(new Peliculas(4, "La llegada", "Denis Villeneuve", 7));
		peliculas.add(new Peliculas(5, "Star Wars: Episodio IV - Una nueva esperanza", "George Lucas", 7));
		
	}
	
	@Override
	public void run() {
		
		System.out.println("Estableciendo comunicación con " + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader eB = null;
		
		addPeliculas();
		
		
		try {
			
			salida = new PrintStream(socketAlCliente.getOutputStream());
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			eB = new BufferedReader(entrada);
			
			//Cçodigo principal para permitir interacción y resolver según las peticiones
			String eleccion = "";
			boolean continuar = true;
			
			
			
			while(continuar) {
				eleccion = eB.readLine();
				
				//AQUÍ igualo al menú de opciones del Cliente.
				switch(eleccion) {
					
				case "1": //RECIBIR LA INFO DEL CLIENTE MEDIANTE iNPUTsTREAM ETC.
					//si elige 1->envío el menú de películas.
					salida.println(peliculas);
					
					//recibo elección entre ellas
					eleccion = eB.readLine();
					
					for(Peliculas pelicula : peliculas ) {
						
						if(pelicula.getID() == Integer.parseInt(eleccion)) {
								salida.println(pelicula);
						}
					}
						
					
					/*
					 * if(eleccion.equals("01")) {
						System.out.println(Servidor.obtenerPeliculas().get(0));
					}else if(eleccion.equals("02")) {
						System.out.println(Servidor.obtenerPeliculas().get(1));
					}else if(eleccion.equals("03")) {
						System.out.println(Servidor.obtenerPeliculas().get(2));
					}else if(eleccion.equals("04")) {
						System.out.println(Servidor.obtenerPeliculas().get(3));
					}else if(eleccion.equals("05")) {
						System.out.println(Servidor.obtenerPeliculas().get(4));
					}
					break;
					 */
					
				case "2": 
					//si elige 1->envío el menú de películas.
					salida.println(peliculas);
						//salida.println(peliculas);
						//salida.println(Servidor.obtenerPeliculas());
					
					//recibo elección entre ellas
					eleccion = eB.readLine();
					
					/**
					 * peliculas.add(new Peliculas(001, "Origen", "Christopher Nolan", 10));
		peliculas.add(new Peliculas(002, "El código DaVinci", "Ron Howard", 9));
		peliculas.add(new Peliculas(003, "Harry Potter y el prisionero de Azkaban", "Alfonso Cuarón", 8));
		peliculas.add(new Peliculas(004, "La llegada", "Denis Villeneuve", 7));
		peliculas.add(new Peliculas(005, "Star Wars: Episodio IV - Una nueva esperanza", "George Lucas", 7)
					 */
					
					for(Peliculas pelicula : peliculas ) {
													
						if(pelicula.getTitulo().contains(eleccion)) {
								salida.println(pelicula);
						}
					}
						
						/*
						 * if(eleccion.trim().equalsIgnoreCase("Origen")) {
									System.out.println(Servidor.obtenerPeliculas().get(0));
						}
						}else if(eleccion.toLowerCase().contains("El código DaVinci".toLowerCase())) {
							System.out.println(Servidor.obtenerPeliculas().get(1));
						}else if(eleccion.toLowerCase().contains("Harry Potter y el prisionero de Azkaban".toLowerCase())) {
							System.out.println(Servidor.obtenerPeliculas().get(2));
						}else if(eleccion.toLowerCase().contains("La llegada".toLowerCase())) {
							System.out.println(Servidor.obtenerPeliculas().get(3));
						}else if(eleccion.toLowerCase().contains("Star Wars: Episodio IV - Una nueva esperanza".toLowerCase())) {
							System.out.println(Servidor.obtenerPeliculas().get(4));
						}
						break;
						 */
							
								
				case "3":
					System.out.println("Programa finalizado");
					continuar = false;
					
					
				}}	
				
				
				
				
			
			
			
		}  catch (IOException e) {
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
		}
		
		//REQUERIMIENTO 3 SON HILOS SINCRONIZADOS??????
		
		
		
		
	}
	

}
