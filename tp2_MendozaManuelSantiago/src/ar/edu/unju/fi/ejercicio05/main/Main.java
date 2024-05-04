package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio05.model.Productos;
import ar.edu.unju.fi.ejercicio05.util.MetodosMain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Productos> productos = new ArrayList<Productos>();
		Scanner leer = new Scanner(System.in);
		
        int opcion;
        	do {
        		try {
	            System.out.println("*********** MENU ***********");
	            System.out.println("1 - Mostrar productos");
	            System.out.println("2 - Realizar compra");
	            System.out.println("3 - Salir");
	            System.out.print("Ingrese su opción: ");
	            opcion = leer.nextInt();
	
	            switch (opcion) {
	                case 1:
	                    System.out.println("Mostrando productos...");
	                    MetodosMain.cargaProductos(productos);
	                    MetodosMain.mostrarProductos(productos);
	                	
	                    break;
	                case 2:
	                    System.out.println("Seleccionar productos para comprar...");
	                    MetodosMain.compra(leer, productos);
	                    //mostrarOpcionesPago(leer, monto);
	                    break;
	                case 3:
	                    System.out.println("Saliendo...");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
	            }
        	} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrido un error. Por favor, ingrese una opción válida.");
            leer.nextLine(); 
            opcion = 0; // Establecer la opción a 0 para que continúe en el bucle
			}
	        
	    } while (opcion != 3);
	    leer.close();
	}
	
	
	
}
