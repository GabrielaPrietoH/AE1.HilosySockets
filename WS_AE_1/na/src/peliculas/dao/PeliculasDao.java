package peliculas.dao;

import packageServidor.Peliculas;

public interface PeliculasDao {
	
	//consultar peli por id, por titulo y salir
	boolean alta(Peliculas peliculas);
	Peliculas buscarId (int id);
	Peliculas buscarTitulo (String titulo);

}
