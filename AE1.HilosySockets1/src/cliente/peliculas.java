package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;

import servidor.BuscadorPeliculas;

public class peliculas {


	public static void main(String[] args) {
	
	    ArrayList<peliculas> BuscadorPeliculas = new ArrayList<>();
        peliculas.add(new BuscadorPeliculas("12345T","The Shawshank Redemption", "Frank Darabont"));
        peliculas.add(new BuscadorPeliculas("12245P","The Godfather", "Francis Ford Coppola"));
        peliculas.add(new BuscadorPeliculas("10092D","The Dark Knight", "Christopher Nolan"));
        peliculas.add(new BuscadorPeliculas("10012M","12 Angry Men", "Sidney Lumet"));
        peliculas.add(new BuscadorPeliculas("23340B","Schindler's List", "Steven Spielberg"));

        System.out.println(BuscadorPeliculas);

        }
	

	public static peliculas add(BuscadorPeliculas buscadorPeliculas) {
	
        BuscadorPeliculas nuevaPelicula = new BuscadorPeliculas("ID","Nueva Película", "Director Desconocido");
        peliculas.add(nuevaPelicula);

       return nuevaPelicula;
    }


	}
		

    


	

	
