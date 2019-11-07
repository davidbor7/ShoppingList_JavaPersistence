package accesoadatos;

import java.io.*;


/**
 * The Class ArticuloAComprar.
 * This Class creates an object of the item type
 * @author David Borrego
 * @version 07/11/2019
 */

public class ArticuloAComprar implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Item descripcion  */
	private String descripcion;
	
	/** Item quantity. */
	private int cantidad;
	
	/** Unit of measurement. */
	private String unidad;

	/**
	 * Instantiates a new Item.
	 *
	 * @param descripcion the Description
	 * @param cantidad the Quantity
	 * @param unidad the Unit of measurement
	 */
	public ArticuloAComprar(String descripcion, int cantidad, String unidad){

		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	

	/**
	 * Item properties
	 *
	 * @return the string
	 */
	public String características_articulo()
	{
		return descripcion + " " + cantidad + unidad;
	}
	
	
	/**
	 * Item name.
	 *
	 * @return the string
	 */
	public String nombre_articulo()
	{
		return descripcion;
	}
}
