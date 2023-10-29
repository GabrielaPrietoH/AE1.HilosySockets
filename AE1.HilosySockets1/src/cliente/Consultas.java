package cliente;



import java.rmi.RemoteException;


public interface Consultas  {
	public String consultarID(String id) throws RemoteException;
	public String consultarTitulo(String titulo) throws RemoteException;
	public String consultarPeliculasPorDirector(String director) throws RemoteException;
	public String AnadirPelicula(peliculas pelicula) throws RemoteException;

	
}
