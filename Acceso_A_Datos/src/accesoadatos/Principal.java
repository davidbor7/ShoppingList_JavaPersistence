package accesoadatos;

import java.io.*;

public class Principal
{
	
	/**
	 * The main method.
	 *@author David Borrego
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @version 07/11/2019
	 */

	static boolean key;
	static boolean key2;
	static String nombre_de_la_lista;
	static String opcion_elegida_string;
	static int opcion_elegida_int;
	static String articulo_seleccionado_string;
	static int articulo_seleccionado_int;
	static File fichero;
	static Object aux;
	static BufferedReader lectura;


	public static void main(String[] args) throws IOException
	{

		//------------INICIALIZE VARIABLES------------

		key = true;
		key2 = true;
		lectura = new BufferedReader (new InputStreamReader (System.in));

		ArticuloAComprar[] stock_de_articulos = new ArticuloAComprar[10];
		stock_de_articulos[0] = new ArticuloAComprar("Caja de Mantecados", 200, "g");
		stock_de_articulos[1] = new ArticuloAComprar("Paquete de Arroz", 1, "Kg");
		stock_de_articulos[2] = new ArticuloAComprar("Paquete de Lentejas", 2, "Kg");
		stock_de_articulos[3] = new ArticuloAComprar("Paquete de Yogur", 6, "Ud.");
		stock_de_articulos[4] = new ArticuloAComprar("Zumo de Pi�a", 1, "L");
		stock_de_articulos[5] = new ArticuloAComprar("Botello de Agua Grande", 5, "L");
		stock_de_articulos[6] = new ArticuloAComprar("Coca-Cola", 6, "Ud.");
		stock_de_articulos[7] = new ArticuloAComprar("Parque de Az�car", 500, "g");
		stock_de_articulos[8] = new ArticuloAComprar("Surtido de Pasteles", 8, "Ud.");
		stock_de_articulos[9] = new ArticuloAComprar("Paquete de Patatas", 50, "g");

		ListaDeLaCompra lista1 = new ListaDeLaCompra("LISTA-1");
		ListaDeLaCompra lista2 = new ListaDeLaCompra("LISTA-2");
		ListaDeLaCompra lista3 = new ListaDeLaCompra("LISTA-3");
		lista1.agregarProductoAComprar(stock_de_articulos[0]);
		lista1.agregarProductoAComprar(stock_de_articulos[3]);
		lista1.agregarProductoAComprar(stock_de_articulos[5]);
		lista1.agregarProductoAComprar(stock_de_articulos[7]);
		lista2.agregarProductoAComprar(stock_de_articulos[1]);
		lista2.agregarProductoAComprar(stock_de_articulos[2]);
		lista2.agregarProductoAComprar(stock_de_articulos[9]);
		lista3.agregarProductoAComprar(stock_de_articulos[4]);



		do{
			System.err.println("------ELIJA UNA LISTA------");
			System.out.println();
			System.out.println("1. LISTA DE DICIEMBRE ");
			System.out.println("2. LISTA DE ENERO ");
			System.out.println("3. LISTA DE JULIO ");
			System.out.println();
			System.out.println("PARA TERMINAR PULSE 0 Y PRESIONE ENTER");
			System.out.println();

			opcion_elegida_string = lectura.readLine();
			opcion_elegida_int = Integer.parseInt(opcion_elegida_string);


			/**
			 *First control structure with switch to first list
			 */

			switch (opcion_elegida_int)
			{
			case 1:

				do {
					

					System.out.println();
					System.err.println("\n------ELIJA UNA ACCI�N------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ART�CULO ");
					System.out.println("4. ELIMINAR ART�CULO ");
					System.out.println("5. VER TODOS LOS ART�CULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATR�S");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					/**
					 *Second control structure with switch to first list
					 */

					switch (opcion_elegida_int){

					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista1.getNombreLista()+ "\n");
						System.out.println();
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 2:
						System.out.println("ESCRIBA EL NUEVO NOMBRE DE LA LISTA: ");
						nombre_de_la_lista = lectura.readLine();
						lista1.setNombreLista(nombre_de_la_lista);
						key2 = true;
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						break;	

					case 3:
						System.out.println();
						System.out.println("------SELECCIONA UNO DE LOS ART�CULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista1.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;	

					case 4:
						System.out.println();
						imprime_articulos_de_la_lista(lista1);
						System.out.println();
						System.out.println("INTRODUCE EL NOMBRE DEL ART�CULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista1.eliminarArticulo(articulo_seleccionado_string);	

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 5:
						System.out.println();
						imprime_articulos_de_la_lista(lista1);
						System.out.println();

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;//Skip to first control structure
						key = true;//Enable first control structure
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						break;

					case 7:	

						fichero = new File("Copia_Seguridad_Lista_1.dat");
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

						oos.writeObject(lista1);
						oos.close();


						break;

					case 8:	
						fichero = new File("Copia_Seguridad_Lista_1.dat");

						try
						{
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
							aux = ois.readObject();
							lista1 = (ListaDeLaCompra) aux;
							ois.close();
						} catch (Exception e1)
						{
							e1.printStackTrace();
						}

						break;

					default:
						System.out.println();
						System.err.println("EL CAR�CTER INTRODUCIDO NO ES V�LIDO");
						System.out.println();
						try //ESTO SE A�ADE PARA GUARDAR EL ORDEN DE IMPRESI�N EN LA CONSOLA
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;
					} 


				}while(key2==true);

				break;


				/**
				 *First control structure with switch to second list
				 */	
			case 2:

				do
				{
					System.out.println();
					System.err.println("\n------ELIJA UNA ACCI�N------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ART�CULO ");
					System.out.println("4. ELIMINAR ART�CULO ");
					System.out.println("5. VER TODOS LOS ART�CULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATR�S");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					

					/**
					 *Second control structure with switch to second list
					 */	
					switch (opcion_elegida_int)
					{
					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista2.getNombreLista()+ "\n");
						System.out.println();
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 2:
						System.out.println("ESCRIBA EL NUEVO NOMBRE DE LA LISTA: ");
						nombre_de_la_lista = lectura.readLine();
						lista2.setNombreLista(nombre_de_la_lista);
						key2 = true;
						break;	

					case 3:
						System.out.println();
						System.out.println("------SELECCIONA UNO DE LOS ART�CULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista2.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;	

					case 4:
						System.out.println();
						imprime_articulos_de_la_lista(lista2);
						System.out.println();
						System.out.println("INTRODUCE EL NOMBRE DEL ART�CULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista2.eliminarArticulo(articulo_seleccionado_string);	

						try
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 5:
						System.out.println();
						imprime_articulos_de_la_lista(lista2);
						System.out.println();

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;//Skip to first control structure
						key = true;//Enable first control structure
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						break;

					case 7:	
						fichero = new File("Copia_Seguridad_Lista_2.dat");
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

						oos.writeObject(lista2);
						oos.close();


						break;

					case 8:	
						fichero = new File("Copia_Seguridad_Lista_2.dat");

						try
						{
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
							aux = ois.readObject();
							lista2 = (ListaDeLaCompra) aux;
							ois.close();
						} catch (Exception e1)
						{
							e1.printStackTrace();
						}

						break;

					default:
						System.out.println();
						System.err.println("EL CAR�CTER INTRODUCIDO NO ES V�LIDO");
						System.out.println();
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;
					} 


				}while(key2==true);

				break;

				/**
				 *First control structure with switch to third list
				 */
			case 3:

				do 
				{
					System.out.println();
					System.err.println("\n------ELIJA UNA ACCI�N------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ART�CULO ");
					System.out.println("4. ELIMINAR ART�CULO ");
					System.out.println("5. VER TODOS LOS ART�CULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATR�S");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					/**
					 *Second control structure with switch to third list
					 */
					switch (opcion_elegida_int)
					{
					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista3.getNombreLista()+ "\n");
						System.out.println();
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 2:
						System.out.println("ESCRIBA EL NUEVO NOMBRE DE LA LISTA: ");
						nombre_de_la_lista = lectura.readLine();
						lista3.setNombreLista(nombre_de_la_lista);
						key2 = true;
						break;

					case 3:
						System.out.println();
						System.out.println("------SELECCIONA UNO DE LOS ART�CULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista3.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;	

					case 4:
						System.out.println();
						imprime_articulos_de_la_lista(lista3);
						System.out.println();
						System.out.println("INTRODUCE EL NOMBRE DEL ART�CULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista3.eliminarArticulo(articulo_seleccionado_string);	

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 5:
						System.out.println();
						imprime_articulos_de_la_lista(lista3);
						System.out.println();

						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;//Skip to first control structure
						key = true;//Enable first control structure
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						break;

					case 7:	
						fichero = new File("Copia_Seguridad_Lista_3.dat");
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

						oos.writeObject(lista3);
						oos.close();
						break;

					case 8:	
						fichero = new File("Copia_Seguridad_Lista_3.dat");

						try
						{
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
							aux = ois.readObject();
							lista3 = (ListaDeLaCompra) aux;
							ois.close();
						} catch (Exception e1)
						{
							e1.printStackTrace();
						}

						break;

					default:
						System.out.println();
						System.err.println("EL CAR�CTER INTRODUCIDO NO ES V�LIDO");
						System.out.println();
						try 
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;
					} 


				}while(key2==true);

				break;

			case 0:
				System.out.println();
				System.exit(0);
				break;	

			default:
				System.out.println();
				System.out.println("EL CAR�CTER INTRODUCIDO NO ES V�LIDO");
				System.out.println();
				break;
			} 

		}while(key==true);
	}

	/**
	 * Print the items inside a Shopping List
	 * 
	 * @param lista the Shopping List
	 */
	public static void imprime_articulos_de_la_lista(ListaDeLaCompra lista)
	{
		for (int i = 0; i < lista.getArticulos().size(); i++)
		{
			System.out.println(lista.getArticulos().get(i).caracter�sticas_articulo());
		}

	}
}
