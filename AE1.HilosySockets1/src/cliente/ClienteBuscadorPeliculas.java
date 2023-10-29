package cliente;

import java.util.Scanner;

public class ClienteBuscadorPeliculas {

	private static Scanner sc;
	
	public static void main(String[] args) {
		

		System.out.println("    APLICACION BUSCADOR PELICULAS CLIENTE   ");
		System.out.println("-------------------------------------");
		
		sc = new Scanner(System.in);
		ConexionAlServidorBuscador cas = new ConexionAlServidorBuscador();
		
		int opcion = 0;
		String resultado = " ";
		
		do {
			
			opcion = mostrarMenu();
			
			if(opcion >=1 && opcion <=4) {
				
				if(opcion == 1) {
				System.out.println("Dime el ID: ");
				
				String ocp2 = sc.nextLine();
				
				resultado = cas.enviarDatos(ocp2, opcion);
				
				System.out.println("La pelicula que buscas es : " + resultado);
				}else if(opcion == 2) {
		
				System.out.println("Dime el Titulo: ");
						
			    String ocp3 = sc.nextLine();
						
			    resultado = cas.enviarDatos(ocp3, opcion);
						
				System.out.println("La pelicula que buscas es : " + resultado);
				
				}else if(opcion == 3) {
		
				System.out.println("Dime el Director: ");
						
				String ocp4 = sc.nextLine();
						
				resultado = cas.enviarDatos(ocp4, opcion);
						
				System.out.println("La pelicula que buscas es : " + resultado);
				}else if(opcion == 3) {
					
			    System.out.println("Escribe ID, Titulo, Director para añadir: ");
					
			    String ocp4 = sc.nextLine();
							
				resultado = cas.enviarDatos(ocp4, opcion);
							
				System.out.println("Pelicula añadida : " + resultado);	
				}
			}
			
		}while(opcion != 5);
		
		System.out.println("BUSCADOR PELICULAS CLIENTE: Fin del programa");
		sc.close();
	}
	
	private static int mostrarMenu() {
	
		System.out.println("ESCOJA UNA DE LAS SIGUIENTES OPERACIONES(1-5):");
	    System.out.println("----------------------------------------------");
	    System.out.println("1. Consultar película por ID");
	    System.out.println("2. Consultar película por título");
	    System.out.println("3. Consultar película por director");
	    System.out.println("4. Añadir pelicula");
	    System.out.println("5. SALIR ");
		
	    int opcion = sc.nextInt();
	    sc.nextLine();
	    
	    return opcion;
				

	}

}
