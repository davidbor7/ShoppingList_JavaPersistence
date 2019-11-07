package accesoadatos;

import java.io.*;

public class Principal
{


	public static void main(String[] args) throws IOException
	{

		//------------CREATE VARIABLES------------
		boolean key = true;
		boolean key2 = true;
		BufferedReader lectura = new BufferedReader (new InputStreamReader (System.in));
		String nombre_de_la_lista;
		String opcion_elegida_string;
		int opcion_elegida_int;
		String articulo_seleccionado_string;
		int articulo_seleccionado_int;
		File fichero;
		Object aux;

		ArticuloAComprar[] stock_de_articulos = new ArticuloAComprar[10];
		stock_de_articulos[0] = new ArticuloAComprar("Caja de Mantecados", 200, "g");
		stock_de_articulos[1] = new ArticuloAComprar("Paquete de Arroz", 1, "Kg");
		stock_de_articulos[2] = new ArticuloAComprar("Paquete de Lentejas", 2, "Kg");
		stock_de_articulos[3] = new ArticuloAComprar("Paquete de Yogur", 6, "Ud.");
		stock_de_articulos[4] = new ArticuloAComprar("Zumo de Piña", 1, "L");
		stock_de_articulos[5] = new ArticuloAComprar("Botello de Agua Grande", 5, "L");
		stock_de_articulos[6] = new ArticuloAComprar("Coca-Cola", 6, "Ud.");
		stock_de_articulos[7] = new ArticuloAComprar("Parque de Azúcar", 500, "g");
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

			switch (opcion_elegida_int)
			{
			case 1:

				do {

					System.out.println();
					System.err.println("\n------ELIJA UNA ACCIÓN------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ARTÍCULO ");
					System.out.println("4. ELIMINAR ARTÍCULO ");
					System.out.println("5. VER TODOS LOS ARTÍCULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATRÁS");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					switch (opcion_elegida_int){

					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista1.getNombreLista()+ "\n");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						break;	

					case 3:
						System.out.println();
						System.out.println("------SELECCIONA UNO DE LOS ARTÍCULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista1.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.out.println("INTRODUCE EL NOMBRE DEL ARTÍCULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista1.eliminarArticulo(articulo_seleccionado_string);	

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;
						key = true;
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.err.println("EL CARÁCTER INTRODUCIDO NO ES VÁLIDO");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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

			case 2:

				do
				{
					System.out.println();
					System.err.println("\n------ELIJA UNA ACCIÓN------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ARTÍCULO ");
					System.out.println("4. ELIMINAR ARTÍCULO ");
					System.out.println("5. VER TODOS LOS ARTÍCULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATRÁS");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					switch (opcion_elegida_int)
					{
					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista2.getNombreLista()+ "\n");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.out.println("------SELECCIONA UNO DE LOS ARTÍCULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista2.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.out.println("INTRODUCE EL NOMBRE DEL ARTÍCULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista2.eliminarArticulo(articulo_seleccionado_string);	

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;
						key = true;
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.err.println("EL CARÁCTER INTRODUCIDO NO ES VÁLIDO");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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

			case 3:

				do 
				{
					System.out.println();
					System.err.println("\n------ELIJA UNA ACCIÓN------");
					System.out.println("1. NOMBRE DE LA LISTA ");
					System.out.println("2. ESTABLECE EL NOMBRE DE LA LISTA ");
					System.out.println("3. AGREGAR ARTÍCULO ");
					System.out.println("4. ELIMINAR ARTÍCULO ");
					System.out.println("5. VER TODOS LOS ARTÍCULOS DE LA LISTA ");
					System.out.println("6. VOLVER ATRÁS");
					System.out.println("7. EXPORTAR COPIA DE SEGURIDAD ");
					System.out.println("8. IMPORTAR COPIA DE SEGURIDAD ");
					System.out.println();

					opcion_elegida_string = lectura.readLine();
					opcion_elegida_int = Integer.parseInt(opcion_elegida_string);

					switch (opcion_elegida_int)
					{
					case 1:	
						System.out.print("EL NOMBRE DE LA LISTA ES: " +lista3.getNombreLista()+ "\n");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.out.println("------SELECCIONA UNO DE LOS ARTÍCULOS DISPONIBLES PARA AGREGARLO A LA LISTA------");
						System.out.println();

						for (int i = 0; i < stock_de_articulos.length; i++)
						{
							System.out.println((i+1) + ". " + stock_de_articulos[i].nombre_articulo());
						}
						System.out.println();

						articulo_seleccionado_string = lectura.readLine();
						articulo_seleccionado_int = Integer.parseInt(articulo_seleccionado_string);		
						lista3.agregarProductoAComprar(stock_de_articulos[articulo_seleccionado_int - 1]); //LE RESTAMOS 1 PARA QUE SELECCIONE EL ELEMENTO CORRECTO DEL ARRAY

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.out.println("INTRODUCE EL NOMBRE DEL ARTÍCULO QUE DESEAS ELIMINAR:");	
						articulo_seleccionado_string = lectura.readLine();						
						lista3.eliminarArticulo(articulo_seleccionado_string);	

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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

						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{

							e.printStackTrace();
						}
						key2 = true;
						break;

					case 6:
						key2 = false;
						key = true;
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
						System.err.println("EL CARÁCTER INTRODUCIDO NO ES VÁLIDO");
						System.out.println();
						try //ESTO SE AÑADE PARA GUARDAR EL ORDEN DE IMPRESIÓN EN LA CONSOLA
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
				System.out.println("EL CARÁCTER INTRODUCIDO NO ES VÁLIDO");
				System.out.println();
				break;
			} 

		}while(key==true);
	}

	public static void imprime_articulos_de_la_lista(ListaDeLaCompra lista)
	{
		for (int i = 0; i < lista.getArticulos().size(); i++)
		{
			System.out.println(lista.getArticulos().get(i).características_articulo());
		}

	}
}
