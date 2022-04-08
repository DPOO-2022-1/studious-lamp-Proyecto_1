package principal;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class Actividad {
	
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fecha_inicial;
	private String fecha_final;
	private Usuario creador;
	private int horaTotal;
	private String horaParcial;
	
	public Actividad(String title, String description, String type, String date_ini, String date_fin,Usuario creator) 
	{
		this.setTitulo(title);
		this.setDescripcion(description);
		this.tipo= type;
		this.fecha_inicial= date_ini;
		this.fecha_final= date_fin;
		this.creador= creator;
	}
	
	// Generador fecha actual
	public String fecha_actual() {  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   return (dtf.format(now));
		  } 
	
	// Get y Set

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha_inicial() {
		return fecha_inicial;
	}
	
	public String getFecha_final() {
		return fecha_final;
	}


	public void setFecha_inicial(String fecha, Boolean fecha_pasada) {
		
		if(fecha_pasada) {
			this.fecha_inicial = fecha;
			
		}else {
			fecha = fecha_actual();
			this.fecha_inicial = fecha;
			}
	}
	
	public void setFecha_final(String fecha, Boolean fecha_pasada) {
		
		if(fecha_pasada) {
			this.fecha_final = fecha;
			;
		}else {
			fecha = fecha_actual();
			this.fecha_final = fecha;}
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public int getHoraTotal() {
		return horaTotal;
	}

	public void darTiempoTotal(int horaTotal, Boolean stop_contador) {
		
		int tiempo_anios = Integer.parseInt(fecha_final.substring(0,4)) - Integer.parseInt((fecha_inicial.substring(0,4)));
		int tiempo_meses = Integer.parseInt(fecha_final.substring(5,7)) - Integer.parseInt((fecha_inicial.substring(5,7)));
		int tiempo_dias = Integer.parseInt(fecha_final.substring(8,10)) - Integer.parseInt((fecha_inicial.substring(8,10)));
		int tiempo_horas = Integer.parseInt(fecha_final.substring(12,14)) - Integer.parseInt((fecha_inicial.substring(12,14)));
		
		horaTotal = (tiempo_anios*8760) + (tiempo_meses*730) + (tiempo_dias*24) + tiempo_horas;
		
		
		
		this.horaTotal = horaTotal;
	}

	public String getHoraParcial() {
		return horaParcial;
	}

	public void setHoraParcial(String horaParcial) {
		this.horaParcial = horaParcial;
	}
	
	

}
