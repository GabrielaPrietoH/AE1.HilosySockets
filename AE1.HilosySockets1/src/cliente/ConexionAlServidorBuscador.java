package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexionAlServidorBuscador {
	
	public static final int PUERTO = 2022;
	public static final String IP_SERVER = "localhost";
	
	/**
	 * Metodo que se conecta a un servidor en "localhost" por el puerto 20220
	 * Envia dos operandos y un código de operación para que sea procesado
	 * por el servidor	 
	
	 * @param op representa el primero operando
	 * @param codigoOperacion, 1 SUMA, 2 RESTA, 3 MULTIPLICACION, 4 DIVISION
	 * @return el resultado de la operacion
	 * 
	 */
	
	public String enviarDatos(String opc3, int opcion) {
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		String iResultado = " ";
		
		try (Socket socketAlServidor = new Socket()){
			
			String mensaje = opc3 + "-" + opcion;
			
			socketAlServidor.connect(direccionServidor);
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			salida.println(mensaje);
			
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			
			String sResultado = bf.readLine();
			iResultado = sResultado;
		
        } catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception  e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
			
		}
		return iResultado;
	}

}
