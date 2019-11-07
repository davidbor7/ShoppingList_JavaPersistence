package accesoadatos;

import java.io.*;
import java.util.*;

/**
 * The Class ListaDeLaCompra.
 * This Class creates an object of shopping list type
 * @author David Borrego
 * @version 07/11/2019
 */
public class ListaDeLaCompra implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Shopping List name */
	private String nombreLista;
	
	/** Shopping List items. */
	private List<ArticuloAComprar> lista_de_articulos;

	/**
	 * Instantiates a new Shopping List withouth name.
	 */
	public ListaDeLaCompra() {

		this.nombreLista = "";
		this.lista_de_articulos = new ArrayList<ArticuloAComprar>();

	}

	/**
	 * Instantiates a new Shopping List.
	 *
	 * @param nombreLista the Shopping List name
	 */
	public ListaDeLaCompra(String nombreLista) {

		this.nombreLista = nombreLista;
		this.lista_de_articulos = new ArrayList<ArticuloAComprar>();
	}


	/**
	 * Gets the Shopping List name
	 *
	 * @return the string
	 */
	public String getNombreLista() {

		return this.nombreLista;
	}


	/**
	 * Sets the Shopping List name.
	 *
	 * @param nombreLista the new Shopping List name
	 */
	public void setNombreLista(String nombreLista) {

		this.nombreLista = nombreLista;

	}

	/**
	 * Add Item.
	 *
	 * @param articulo the Item
	 */
	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista_de_articulos.add(articulo);

	}

	/**
	 * Delete Item.
	 *
	 * @param descripcionArticulo the Item propierties
	 */
	public void eliminarArticulo (String descripcionArticulo) {

		String descripcion = descripcionArticulo;
		boolean llave = true;
		for (int i = 0; i < lista_de_articulos.size(); i++)
		{
			if((lista_de_articulos.get(i).nombre_articulo()).equals(descripcion)) {
				System.out.println();
				System.out.println("ELIMINADO CORRECTAMENTE.");
				lista_de_articulos.remove(i);
				llave = false;
			}
		}	
		if(llave==true)
		{
			System.out.println();
			System.out.println("ERROR.NO HAS INTRODUCIDO CORRECTAMENTE EL NOMBRE DEL ARTÍCULO.");
		}
	}
	
	/**
	 * Gets Items in the Shopping List.
	 *
	 * @return the Items
	 */
	public List <ArticuloAComprar> getArticulos(){

		return lista_de_articulos;

	}
}
