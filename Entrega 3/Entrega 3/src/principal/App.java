package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	private Usuario usuarioActual;
	private Proyecto proyectoActual = null;
	
	public App() {
		System.out.println("-------------------- APP -------------------- ");
		
		System.out.println("Por Favor ingrese sus datos:");
		
		String nombre = input("Nombre del usuario: \n");
		String correo = input("Correo del usuario: \n");
		
		this.usuarioActual = new Usuario(nombre, correo);
		
	}
	
	// metodos procesos
	
	public void Menu() {
		
		boolean continuar = true;
		while (continuar) {
			ImprimirMenu();
			int opcion = Integer.parseInt(input("Elige una opcion: \n"));
			
			if (opcion == 1) {
				
				crearProyecto();
			}
			else if (opcion == 2){
				
				crearActividad();
			} 
			else if (opcion == 0){
				
				continuar = false;
				
			}
			
			
		}
		
	}
	
	public void crearActividad() {
		
		Actividad actividad= new Actividad("", "", "", "", "",this.usuarioActual);
		
		if(proyectoActual == null) 
		{
			System.out.println("*ERROR*\n No hay un proyecto activo, por favor cargue un proyecto o cree uno nuevo para agregar una nueva actividad.");
		}
		else
		{
			String nombre = input("Ingrese el nombre de la actividad:\n");
			actividad.setTitulo(nombre);
			String descripcion = input("Ingrese una descripción para la actividad:\n");
			actividad.setDescripcion(descripcion);
			
			Boolean fecha_pasada = false;
			String es_pasada = input("Digite 1 si va a iniciar un contador par la fecha inicial, 0 si ingresara una fecha inicial antigua");
			if( es_pasada == "0") {
				fecha_pasada = true;
				String fechaIn = input("Digite la fecha de inicio de la actividad:\n");
				actividad.setFecha_inicial(fechaIn, fecha_pasada);
			}
			else {
				String fechaIn = "";
				actividad.setFecha_inicial(fechaIn, fecha_pasada);
			}
			
			Boolean fecha_pasada1 = false;
			String es_pasada1 = input("Digite 1 si va a iniciar un contador par la fecha inicial, 0 si ingresara una fecha inicial antigua");
			if( es_pasada1 == "0") {
				fecha_pasada1 = true;
				String fechaFin = input("Digite la fecha de final de la actividad:\n");
				actividad.setFecha_final(fechaFin,fecha_pasada1);
			}
			else{
				String fechaFin = "";
				actividad.setFecha_final(fechaFin,fecha_pasada1);
			}
			}
			String tipo = input("Digite el tipo de actividad que se realiza:\n");
			actividad.setTipo(tipo);
			System.out.println("Por defecto el usuario que realiza la actividad es el usuario actual ¿Desea cambiar el usuario que la realiza?\n");
			String cambio= input("(S/N):\n");
			if(cambio.equals("S")) 
			{
				String nusuario = input("Digite el nombre del usuario: \n");
				String cusuario = input("Digite el correo del usuario: \n");
				Usuario nuevo = new Usuario(nusuario, cusuario);
				actividad.setCreador(nuevo);
			}
			else 
			{
				actividad.setCreador(this.usuarioActual);
			}
			
			proyectoActual.agregarActividad(actividad);
			
		}
	
	public void cambiarProyecto(Proyecto proy) {
		proyectoActual = proy;
	}
		
	public void agregarUsuarioCon(Usuario us) {
		
		proyectoActual.agregarUsuarioSec(us); 
		
	}
	
	
	public void crearProyecto() {
		
		String nombre = input("Ingrese el nombre del proyecto:\n");
		String descripcion = input("Ingrese la descripcion del proyecto:\n");
		String fechaInicio = input("Ingrese la fecha inicial del proyecto:\n");
		
		String pregunta1 = input("se conoce la fecha final (S/N)\n");
		
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
		
		System.out.println("1) Crear nuevo proyecto");
		
		System.out.println("2) Agregar una actividad al proyecto actual:");
		
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
