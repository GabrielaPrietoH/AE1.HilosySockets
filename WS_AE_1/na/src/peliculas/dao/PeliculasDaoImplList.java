package peliculas.dao;

import java.util.ArrayList;

import packageServidor.Peliculas;

public class PeliculasDaoImplList implements PeliculasDao {
	
	private ArrayList<Peliculas> lista;
	
	//Constructores
	
	public PeliculasDaoImplList() {
		lista = new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		
	}

	@Override
	public Peliculas buscarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Peliculas buscarTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
