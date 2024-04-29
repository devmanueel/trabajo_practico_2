 package ar.edu.unju.fi.ejercicio04.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio04.model.Jugador;
import ar.edu.unju.fi.ejercicio04.util.MetodosMain;


public class Main {

	public static void main(String[] args) {
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Scanner lerScanner = new Scanner(System.in);
        int opcion = 0;
		
        do {
        	System.out.println("----------------------------------------------");
            System.out.println("\n\t\tMENÚ DE JUGADORES");
            System.out.println("----------------------------------------------");
            System.out.println("1. Alta de jugador");
            System.out.println("2. Mostrar datos de los jugadores ");
            System.out.println("3. Modificar datos de un jugador");
            System.out.println("4. Eliminar un jugador");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = lerScanner.nextInt();
                lerScanner.nextLine(); // Consumir salto de línea

                switch (opcion) {
                    case 1:
                    	MetodosMain.agregarJugador(lerScanner,jugadores);
                        break;
                    case 2:
                        MetodosMain.mostrarDatosJugador(lerScanner,jugadores);
                        break;
                    case 3:
                        MetodosMain.modificarJugador(lerScanner, jugadores);
                        break;
                    case 4:
                    	MetodosMain.eliminarJugador(lerScanner, jugadores);
                        break;
                    case 5:
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
        } while (opcion != 5);

        lerScanner.close();
	}
	
	
}
