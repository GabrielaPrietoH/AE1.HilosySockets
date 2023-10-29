package servidor;

import java.util.Objects;

import cliente.peliculas;

public class BuscadorPeliculas extends peliculas {
	
	private String ID;
	private String titulo;
	private String director;
	
	
	public BuscadorPeliculas() {
		super();
	}


	public BuscadorPeliculas(String iD, String titulo, String director) {
		super();
		ID = iD;
		this.titulo = titulo;
		this.director = director;
	}


	public String getID() {
		return ID;
	}




	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ID, director, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuscadorPeliculas other = (BuscadorPeliculas) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(director, other.director)
				&& Objects.equals(titulo, other.titulo);
	}


	@Override
	public String toString() {
		return "BuscadorPeliculas [ID=" + ID + ", titulo=" + titulo + ", director=" + director + "]";
	}



	
	
	

	
}
