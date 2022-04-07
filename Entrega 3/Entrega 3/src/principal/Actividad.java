package principal;

public class Actividad {
	
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fecha;
	private Usuario creador;
	private String horaTotal;
	private String horaParcial;
	
	public Actividad(String title, String description, String type, String date, Usuario creator) 
	{
		this.setTitulo(title);
		this.setDescripcion(description);
		this.tipo= type;
		this.fecha= date;
		this.creador= creator;
	}

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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public String getHoraTotal() {
		return horaTotal;
	}

	public void darTiempoTotal(String horaTotal) {
		this.horaTotal = horaTotal;
	}

	public String getHoraParcial() {
		return horaParcial;
	}

	public void setHoraParcial(String horaParcial) {
		this.horaParcial = horaParcial;
	}
	

}
