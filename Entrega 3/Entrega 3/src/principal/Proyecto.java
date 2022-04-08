package principal;

import java.util.ArrayList;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private String fechaInicial;
	private String fechaFinal;
	private String tipo;
	private ArrayList<Actividad> actividades;
	private Usuario principal;
	private ArrayList<Usuario> usuariosSec = new ArrayList<Usuario>();
	
	
	public Proyecto(String nom, String desc, String fechIn, String fechFin, String tip, Usuario usu) {
		
		nombre = nom;
		descripcion = desc;
		fechaInicial = fechIn;
		fechaFinal = fechFin;
		setTipo(tip);
		principal = usu;
		ArrayList<Actividad> act= new ArrayList<Actividad>();
		setActividades(act);
	}
	
// Get y Set
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Usuario getPrincipal() {
		return principal;
	}

	public void setPrincipal(Usuario principal) {
		this.principal = principal;
	}
	
	public String darNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
// Procesos
	
	public void agregarActividad(Actividad activity) 
	{
		this.actividades.add(activity);
	}
	
	public void agregarUsuarioSec(Usuario usu) {
		this.usuariosSec.add(usu);
	}
	
	public String generarReporteTxt() {
		
		String texto1 = "nombreProy: " + nombre + "\nDescripcion: " + descripcion + "\nTipo: " + tipo + "\nFechaIni: " + 
		fechaInicial + "\nFechaFin: " + fechaFinal + "\n\nUsuario Principal\n\n";
		
		String texto2 = "UsuarioPrin: " + principal.DarNombre() + "\nCorreo: " + principal.DarCorreo();
		
		String texto3 = "\n\nUsuarios Secundarios\n\n";
		
		for(Usuario x: usuariosSec) {
			
			String textoMom = "Usuario: " + x.DarNombre() + "\nDescripcion: " + x.DarCorreo();
			texto3 = texto3.concat(textoMom);
		}
		
		return texto1+texto2+texto3;
	}
	
}







