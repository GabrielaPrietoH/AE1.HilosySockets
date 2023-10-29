package servidor;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movies = new ArrayList<Movie>();

    public Movies() {
        this.dummyData();
    }

    public Movie consultarPorID(int id){
        for(Movie movie: this.movies){
            if(movie.getID()==id){
                return movie;
            }
        }
        return null;
    }

    public Movie consultarPorTitulo(String titulo){
        for(Movie movie: this.movies){
            if(movie.getTitle() == titulo){
                return movie;
            }
        }
        return null;
    }


    private void dummyData() {
        // Rellenar la lista de peliculas;
        Movie m1 = new Movie(1, "The Shawshank Redemption", "paco", 12.80);
        Movie m2 = new Movie(2, "The Godfather", "peco", 35.20);
        Movie m3 = new Movie(3, "The Dark Knight", "pico", 3.50);
        Movie m4 = new Movie(4, "Pulp Fiction", "poco", 70);
        Movie m5 = new Movie(5, "The Lord of the Rings", "puco", 1.10);
        
        this.movies.add(m1);
        this.movies.add(m2);
        this.movies.add(m3);
        this.movies.add(m4);
        this.movies.add(m5);
    }

}

