package accesoadatos;

import java.io.*;

public class ArticuloAComprar implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private int cantidad;
	private String unidad;

	public ArticuloAComprar(String descripcion, int cantidad, String unidad){

		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;

	}

	public String características_articulo(){


		return descripcion + " " + cantidad + unidad;


	}
	public String nombre_articulo(){


		return descripcion;


	}
}
