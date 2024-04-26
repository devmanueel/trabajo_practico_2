package ar.edu.unju.fi.ejercicio01.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio01.util.Submenus;



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
            //llamada a la clase submenus origen de fabricacion
            OrigenFabricacion origenFabricacion = Submenus.subMenuOf(entrada);
             
            //lamada a la clase submenu de producto
            Categoria categoria = Submenus.subMenuCP(entrada);
            //creacion de objeto
            Producto producto = new Producto(codigo, descrpcion, precio, origenFabricacion, categoria);
            productos.add(producto);
            
            System.out.println(productos.size()+"Producto creado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al dar de alta El Producto. \n Motivo del Eror: Datos incorrectos");
            entrada.nextLine();
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
        	//MOdificando Producto
        	Submenus.SubModificacion(leerScanner, producto);
                    	
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
