package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	Usuario usuarioActual;
	Proyecto proyectoActual = null;
	
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
				
				CrearProyecto();
			}
			else if (opcion == 0){
				
				continuar = false;
				
			}
			
			
		}
		
	}
	
	public void CrearProyecto() {
		
		String nombre = input("Ingrese el nombre del proyecto:");
		String descripcion = input("Ingrese la descripcion del proyecto:");
		String fechaInicio = input("Ingrese la fecha inicial del proyecto:");
		
		String pregunta1 = input("se conoce la fecha final (S/N)");
		
		String fechaFin = "a";
		
		if (pregunta1 == "S") {
			
			fechaFin = input("Ingrese la fecha final proyecto (en caso de no tener escriba No):");
			
		} else {
			
			fechaFin = "no";
			
		}
		
		String tipo = input("Ingrese el tipo del proyecto:");
			
		
		proyectoActual = new Proyecto(nombre, descripcion, fechaInicio, fechaFin, tipo, usuarioActual);
		
	}
	
	// Metodos Imprimir
	
	public void ImprimirInfoUsuario() {
		System.out.println( usuarioActual.DarInfo() );
	}
	
	public void ImprimirMenu() {
		
		if (proyectoActual == null) {
			
			System.out.println("\nNo hay proyecto activo \n");
			
		} else {
			
			System.out.println("\nEl proyecto actual es: " + proyectoActual.darNombre());
			
		}	
		
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
