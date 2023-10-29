package packageServidor;

import java.util.Objects;

public class Peliculas {
	
	private int id;
	private double precio;
	private String titulo, director;
	
	public Peliculas(int id, String titulo, String director, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.precio = precio;
		
	}

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		this.id = iD;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peliculas other = (Peliculas) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", precio=" + precio + ", titulo=" + titulo + ", director=" + director + "]";
	}
	
	
	
	
	
	
}
