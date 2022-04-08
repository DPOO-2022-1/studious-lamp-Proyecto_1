package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Impresora {
	
	
	private String nombre;
	private String descripcion;
	private String fechaInicial;
	private String fechaFinal;
	private String tipo;
	
	private String nomUsuario;
	private String corUsuario;
	private Usuario principal;

	public void CrearArch(String texto, String nombre) {

		try {

			String ruta = "./Data/" + nombre + ".txt";

			File file = new File(ruta);

			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Proyecto leerArch(String nombre) {
		
		try {

			String rout = "./Data/" + nombre + ".txt";
			
			File file = new File(rout);
			
			BufferedReader obj = new BufferedReader(new FileReader(file));
			
			String lin;
			
			while( (lin = obj.readLine()) != null ) {
				interpretarLin(lin);
			}
			
			obj.close();
			
			//System.out.println(this.nombre + " 1 " + descripcion + " 2 " + fechaInicial + " 3 " + fechaFinal + " 4 " + tipo + " 5 " + nomUsuario + " 6 " + corUsuario);
			Proyecto proy = new Proyecto(this.nombre, descripcion, fechaInicial, fechaFinal, tipo, principal);
			
			return proy;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void interpretarLin(String lin) {
		
		String[] secundaria = lin.split(" ");
		
		if ("nombreProy:".equals(secundaria[0])) {
			nombre = secundaria[1];
		} else if ("Descripcion:".equals(secundaria[0])) {
			descripcion = secundaria[1];
		} else if ("Tipo:".equals(secundaria[0])) {
			tipo = secundaria[1];
		} else if ("FechaIni:".equals(secundaria[0])) {
			fechaInicial = secundaria[1];
		} else if ("FechaFin:".equals(secundaria[0])) {
			fechaFinal = secundaria[1];
		} else if ("UsuarioPrin:".equals(secundaria[0])) {
			nomUsuario = secundaria[1];
		} else if ("CorreoPrin:".equals(secundaria[0])) {
			corUsuario = secundaria[1];
			principal = new Usuario(nomUsuario, corUsuario);
		}
		
	}
	
}
