package ar.edu.unju.fi.ejercicio01.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Submenus {
	public Submenus() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static OrigenFabricacion subMenuOf(Scanner entrada) {
	    int op = 0; 
	    OrigenFabricacion origenFabricacion = null; 
	    
	    try {
	        System.out.print("Ingrese Origen de fabricacion: ");
	        System.out.println("\n----------- Origen de fabricacion -----------\n");
	        System.out.println("1- Argentina ");
	        System.out.println("2- China ");
	        System.out.println("3- Brasil ");
	        System.out.println("4- Uruguay ");
	        System.out.println("----------------------------------------------");
	        System.out.println("Ingrese una opcion: ");

	        do {
	            op = entrada.nextInt();

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

	        entrada.nextLine(); // Limpiar el búfer del escáner
	    } catch (InputMismatchException e) {
	        System.out.println("Entrada inválida. Se esperaba un número entero.");
	        entrada.nextLine(); // Limpiar el búfer del escáner en caso de que se haya ingresado un tipo de dato incorrecto
	    }
	    
	    return origenFabricacion; // Devuelve el valor seleccionado
	    
	}
	
	public static Categoria subMenuCP(Scanner entrada) {
	 
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
	 return categoria;  
	}
	
	public static void  SubModificacion(Scanner entrada, Producto prod) {
		  if (prod != null) {
              System.out.println("\n----------- Modificacion -----------\n");
              System.out.println("1- Descripción ");
              System.out.println("2- Precio Unitario ");
              System.out.println("3- Origen Fabricacion ");
              System.out.println("4- Categoria ");
              System.out.println("----------------------------------------------");
              System.out.println("Ingrese una opcion: ");
              int op3 = entrada.nextInt(); 
	            do {
						switch (op3) {
				            case 1:
				            	System.out.println("Ingrese Nueva descripcion");
				            	 String descString = entrada.nextLine();
				            	 prod.setDescripcion(descString);
				                break;
				            case 2:
				            	System.out.println("Ingrese nuevo Precio");
				            	double pecio = entrada.nextInt();
				            	prod.setPrecioUnitario(pecio);
				                break;
				            case 3:
				            	System.out.println("Seleccione Nuevo Origen de Fabricacion: ");
				            	OrigenFabricacion mOrigenFabricacion= subMenuOf(entrada);
				            	prod.setOrigenFabricacion(mOrigenFabricacion);
				                break;
				            case 4:
				            	System.out.println("Seleccione Nueva Categoria: ");
				            	Categoria mCategoria = subMenuCP(entrada);
				            	prod.setCategoria(mCategoria);
				            	
				                break;
				            default:
				                System.out.println("Opción no válida. Intente nuevamente.");
					}
				} while ( !(op3 == 4 || op3 == 1 || op3 == 2 || op3 == 3) );
	            
          } else {
              System.out.println("Producto No encontrado.");

          }
		 
	}
	
}
	