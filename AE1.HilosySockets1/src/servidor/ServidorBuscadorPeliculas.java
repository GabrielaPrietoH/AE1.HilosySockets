package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cliente.peliculas;

public class ServidorBuscadorPeliculas {

		public static final int PUERTO = 2022;
		

		public static void main(String[] args) throws InterruptedException {
			
			System.out.println("    APLICACIÓN BUSCADOR PELICULAS DE SERVIDOR    ");
			System.out.println("------------------------------------------");
			
			InputStreamReader entrada = null;
			PrintStream salida = null;
			
			Socket socketAlCliente = null;
			
			InetSocketAddress direcion = new InetSocketAddress(PUERTO);
			
			
			try (ServerSocket serverSocket = new ServerSocket()){
				
				serverSocket.bind(direcion);
				
				while(true) {
					socketAlCliente = serverSocket.accept();
					
					entrada = new InputStreamReader(socketAlCliente.getInputStream());
					BufferedReader bf = new BufferedReader(entrada);
					
					String stringRecibido = bf.readLine();
					
					System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
					
					
					String[] peliculas = stringRecibido.split("-");
				 
				    int op = 0;//Codigo de operacion que se envia
				    
				    String resultado = "";
				    
				    if(op == 1) {
				    	
				    	BuscadorPeliculas[] pelicula = null;
						for(BuscadorPeliculas p : pelicula) {
							if(p.getID()==resultado) {
								resultado = resultado + p + "\n";
							}
						}
					
				    }else if(op == 2) {
					
				    	BuscadorPeliculas[] pelicula = null;
						for(BuscadorPeliculas p : pelicula) {
							if(p.getTitulo().contains(stringRecibido)) {
								resultado = resultado + p + "\n";
							}
						}
						
				    }else if(op == 3) {
				    	
						BuscadorPeliculas[] pelicula = null;
						for(BuscadorPeliculas p : pelicula) {
							if(p.getDirector().contains(stringRecibido)) {
								resultado = resultado + p + "\n";
							}
						}
					
				    }else if(op == 4) {
				    	BuscadorPeliculas.add(null);
						resultado = resultado + "La pelicula se ha añadido " + peliculas;
						
				    }
				   
				    salida = new PrintStream(socketAlCliente.getOutputStream());
				    salida.println(resultado);
				    socketAlCliente.close();
				}
			} catch (IOException e) {
				System.err.println("SERVIDOR: Error de entrada/salida");
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("SERVIDOR: Error -> " + e);
				e.printStackTrace();
			}
		}
   
			
		}// FIN DEL PROGRAMA
  

