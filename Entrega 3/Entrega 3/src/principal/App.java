package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	Usuario usuarioActual;
	Proyecto proyectoActual;
	
	public App() {
		System.out.println("-------------------- APP -------------------- \n");
		
		System.out.println("Por Favor ingrese sus datos");
		
		String nombre = input("nombre del usuario: ");
		String correo = input("correo del usuario: ");
		
		usuarioActual = new Usuario(nombre, correo);
		
	}
	
	// metodos procesos
	
	public void Menu() {
		
		boolean continuar = true;
		while (continuar) {
			ImprimirMenu();
			int opcion = Integer.parseInt(input("Elige una opcion: "));
			
			if (opcion == 1) {
				
				//Crear proy
			}
			else if (opcion == 0){
				
				continuar = false;
				
			}
			
			
		}
		
	}

	// Metodos Imprimir
	
	public void ImprimirInfoUsuario() {
		System.out.println( usuarioActual.DarInfo() );
	}
	
	public void ImprimirMenu() {
		
		System.out.println("1) Crear proyecto");
		
		System.out.println("0) Cerrar App");
	}
	
	// Propio de la app
	
	public static void main(String[] args) {
		
		App aplicacion = new App();
		
		System.out.println("-------------------- MENU -------------------- \n");
		
		aplicacion.Menu();
		
		// Guardar datos presistencia
		
	}
	
	private String input(String string) {
		
		try{
		
		System.out.println(string);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
		}
		catch(IOException e) {
			
			System.out.println("Error leyendo");
			e.printStackTrace();
		}
		return null;
	}

}
