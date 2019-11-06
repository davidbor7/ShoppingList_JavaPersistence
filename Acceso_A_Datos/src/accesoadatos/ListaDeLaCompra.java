package accesoadatos;

import java.io.Serializable;
import java.util.*;

public class ListaDeLaCompra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombreLista;
	private List<ArticuloAComprar> lista_de_articulos;

	public ListaDeLaCompra() {

		this.nombreLista = "";
		this.lista_de_articulos = new ArrayList<ArticuloAComprar>();

	}

	public ListaDeLaCompra(String nombreLista) {

		this.nombreLista = nombreLista;
		this.lista_de_articulos = new ArrayList<ArticuloAComprar>();
	}


	public String getNombreLista() {

		return this.nombreLista;
	}


	public void setNombreLista(String nombreLista) {

		this.nombreLista = nombreLista;

	}

	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista_de_articulos.add(articulo);

	}

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
	public List <ArticuloAComprar> getArticulos(){

		return lista_de_articulos;

	}
}
