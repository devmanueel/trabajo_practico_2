package ar.edu.unju.fi.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Categoria;
import ar.edu.unju.fi.model.Producto.OrigenFabricacion;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<Producto>();
		Scanner lerScanner = new Scanner(System.in);
        int opcion = 0;

        do {
        	System.out.println("----------------------------------------------");
            System.out.println("\n\t\tMENU PRODUCTOS");
            System.out.println("----------------------------------------------");
            System.out.println("1) Crear Producto");
            System.out.println("2) Mostrar Producto ");
            System.out.println("3) Modificar Producto (sólo puede modificar: descripción, precio unitario, origen fabricación categoría)");
            System.out.println("4) Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = lerScanner.nextInt();
                lerScanner.nextLine(); 

                switch (opcion) {
                    case 1:
                    	crearProducto(lerScanner,productos);
                        break;
                    case 2:
                       mostrarProductos(productos);
                        break;
                    case 3:
                    	modificarProducto(lerScanner, productos);
                        break;
                    case 4:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                lerScanner.nextLine(); // Limpiar entrada errónea
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado. Motivo: " + e.getMessage());
            }
        } while (opcion != 4);

		
	}

	private static void crearProducto(Scanner entrada, List<Producto> productos) {
        try {
            System.out.print("Ingrese el Codigo de Producto: ");
            int codigo = entrada.nextInt();
            entrada.nextLine(); 
            System.out.print("Ingrese descripcion del Producto: ");
            String descrpcion = entrada.nextLine();
            System.out.print("Ingrese Precio Unitario: ");
            double precio = entrada.nextDouble();
            entrada.nextLine(); 
            System.out.print("Ingrese Origen de fabricacion: ");
            System.out.println("\n----------- Origen de fabricacion -----------\n");
            System.out.println("1- Argentina ");
            System.out.println("2- China ");
            System.out.println("3- Brasil ");
            System.out.println("4- Uruguay ");
            System.out.println("----------------------------------------------");
            System.out.println("Ingrese una opcion: ");
            int op = entrada.nextInt();
            OrigenFabricacion origenFabricacion = null;
            do {
					switch (op) {
			            case 1:
			            	origenFabricacion = OrigenFabricacion.ARGENTINA;
			                break;
			            case 2:
			            	origenFabricacion = OrigenFabricacion.CHINA;
			                break;
			            case 3:
			            	origenFabricacion = OrigenFabricacion.BRASIL;
			                break;
			            case 4:
			            	origenFabricacion = OrigenFabricacion.URUGUAY;
			                break;
			            default:
			                System.out.println("Opción no válida. Intente nuevamente.");
	            
				}
			} while (!(op == 4 || op == 1 || op == 2 || op == 3));
            entrada.nextLine(); 
            
            
            System.out.print("Ingrese Categoria de Producto: ");
            System.out.println("\n----------- Categoria -----------\n");
            System.out.println("1- Telefonia ");
            System.out.println("2- Informatica ");
            System.out.println("3- Electro Hogar ");
            System.out.println("4- Herramientras ");
            System.out.println("----------------------------------------------");
            System.out.println("Ingrese una opcion: ");
            int op2 = entrada.nextInt();
            Categoria categoria =null;
            do {
					switch (op2) {
			            case 1:
			            	categoria = Categoria.TELEFONIA;
			                break;
			            case 2:
			            	categoria = Categoria.INFORMATICA;
			                break;
			            case 3:
			            	categoria = Categoria.ELECTROHOGAR;
			                break;
			            case 4:
			            	categoria = Categoria.HERRAMIENTAS;
			                break;
			            default:
			                System.out.println("Opción no válida. Intente nuevamente.");
				}
			} while ( !(op2 == 4 || op2 == 1 || op2 == 2 || op2 == 3) );
            entrada.nextLine(); 
            Producto producto = new Producto(codigo, descrpcion, precio, origenFabricacion, categoria);
            productos.add(producto);
            
            System.out.println(productos.size()+"Producto creado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al dar de alta El Producto./n Motivo del Eror: " + e.getMessage());
        }
     
	}
	
        private static void mostrarProductos(List<Producto> productos) {
        	if (productos.isEmpty()) {
                System.out.println("No hay Productos.");
            } else {
                for (Producto product : productos) {
                    System.out.println(product);
                }
            }
        }
	
        
        
        private static void modificarProducto(Scanner leerScanner, List<Producto> productos) {
        	
        	System.out.print("Ingrese Codigo Producto: ");
        	int cod = leerScanner.nextInt();
        	Producto producto = buscarProducto(cod, productos);
        	
            if (producto != null) {
               int op3 = leerScanner.nextInt();
	            do {
						switch (op3) {
				            case 1:
				            	
				                break;
				            case 2:
				            	
				                break;
				            case 3:
				            	
				                break;
				            case 4:
				            	
				                break;
				            default:
				                System.out.println("Opción no válida. Intente nuevamente.");
					}
				} while ( !(op3 == 4 || op3 == 1 || op3 == 2 || op3 == 3) );
	            
            } else {
                System.out.println("Producto No encontrado.");

            }
            
        }
            
        	private static Producto buscarProducto(int codigo, List<Producto> productos) {       	
                    // Buscar producto
                    System.out.println("\nBuscar por codigo Producto: ");
                    for (Producto codProducto : productos) {
                    	if (codProducto.getCodigo()==(codigo)) {
                    		return codProducto;
                    	}
                    }
        			return null;     
        	}
        	
}
