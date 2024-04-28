package ar.edu.unju.fi.ejercicio02.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import ar.edu.unju.fi.ejercicio02.util.MetodosMain;



public class Main {

	public static void main(String[] args) {
		List<Efemeride> efemerides = new ArrayList<Efemeride>();
		Scanner leerScanner = new Scanner(System.in);
		
		 int opcion = 0;
		 do {
	        	System.out.println("----------------------------------------------");
	            System.out.println("\n\t\tMENU EFEMERIDES");
	            System.out.println("----------------------------------------------");
	            System.out.println("1) Crear Efemeride");
	            System.out.println("2) Mostrar Efemeride ");
	            System.out.println("3) Eliminar Efemeride ");
	            System.out.println("4) Modificar Efemeride");
	            System.out.println("5) Salir");
	            System.out.print("Ingrese una opción: ");

	            try {
	                opcion = leerScanner.nextInt();
	                leerScanner.nextLine(); 

	                switch (opcion) {
	                    case 1:
	                    	MetodosMain.crearEfemeride(leerScanner, efemerides);
	                        break;
	                    case 2:
	                    	MetodosMain.mostrarEfemerides(efemerides);
	                    	//mostrarEfemerides(efemerides);
	                        break;
	                    case 3:
	                    	MetodosMain.eliminarEfemeride(efemerides, leerScanner);
	                    	//eliminarEfemeride(efemerides, leerScanner);
	                        break;
	                    case 4:
	                    	MetodosMain.modificarEfemeride(leerScanner, efemerides);
	                    	//modificarJugador(leerScanner, efemerides);
	                        break;
	                    case 5:
	                    	System.out.println("************** Saliendo Del Programa **************");
	                        break;
	                    default:
	                        System.out.println("Opción no válida. Intente nuevamente.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar un número entero.");
	                leerScanner.nextLine(); // Limpiar entrada errónea
	            } catch (Exception e) {
	                System.out.println("Ocurrió un error inesperado. Motivo: " + e.getMessage());
	            }
	        } while (opcion != 5);
				
	}

	
}
