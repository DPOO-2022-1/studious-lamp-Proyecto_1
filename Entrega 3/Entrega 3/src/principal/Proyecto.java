package principal;

public class Proyecto {
	
	String nombre;
	String descripcion;
	String fechaInicial;
	String fechaFinal;
	String tipo;
	
	Usuario principal;
	
	public Proyecto(String nom, String desc, String fechIn, String fechFin, String tip) {
		
		nombre = nom;
		descripcion = desc;
		fechaInicial = fechIn;
		fechaFinal = fechFin;
		tipo = tip;
		
	}
	
}
