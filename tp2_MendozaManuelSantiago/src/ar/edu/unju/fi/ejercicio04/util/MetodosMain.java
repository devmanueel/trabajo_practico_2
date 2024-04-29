package ar.edu.unju.fi.ejercicio04.util;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class MetodosMain {
	
	//metodo para agregar a un jugador
			public static void agregarJugador(Scanner entrada, List<Jugador> jugadores) {
				Posicion posicion = null;
				
		        try {
		            System.out.print("Ingrese el nombre del jugador: ");
		            String nombre = entrada.nextLine();

		            System.out.print("Ingrese el apellido del jugador: ");
		            String apellido = entrada.nextLine();

		            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
		            LocalDate fechaNacimiento = LocalDate.parse(entrada.nextLine());

		            System.out.print("Ingrese la nacionalidad del jugador: ");
		            String nacionalidad = entrada.nextLine();

		            System.out.print("Ingrese la estatura del jugador (en cm): ");
		            double estatura = entrada.nextDouble();
		            entrada.nextLine();

		            System.out.print("Ingrese el peso del jugador (en kg): ");
		            double peso = entrada.nextDouble();
		            entrada.nextLine(); 
		            String op;
		            
		            do {
		            	System.out.print("Ingrese la posición del jugador (delantero, medio, defensa, arquero): ");
			            String opString = entrada.nextLine();
			            op = opString.toUpperCase();
			            switch (op) {
						case "DELANTERO": 
							posicion = Posicion.DELANTERO;
							break;
						case "MEDIO":
							posicion = Posicion.MEDIO;
							break;
						case "DEFENSA":
							posicion = Posicion.DEFENSA;
							break;
						case "ARQUERO":
							posicion = Posicion.ARQUERO;
							break;
						default:
							System.out.println("Opción no válida. Intente nuevamente.");
						}
					} while (!(op.equals("DELANTERO") || op.equals("MEDIO") || op.equals("DEFENSA") || op.equals("ARQUERO")));
		           
		            // Crear un nuevo objeto Jugador y agregarlo al ArrayList
		            Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
		            jugadores.add(jugador);
		            System.out.println(jugadores.size()+"Jugador dado de alta correctamente.");
		            
		        } catch (Exception e) {
		            System.out.println("Error al dar de alta al jugador./n Motivo del Eror : Datos Incorrectos " + e.getMessage());
		        }
		        
		    
		}
			
			
			//Metodo para mostrar los datos
			public static void mostrarDatosJugador(Scanner entrada, List<Jugador> jugadores) {
				
		        System.out.println("********* "+ "Cantidad Jugadores: "+jugadores.size()+" ************");
				try {
		            System.out.print("Ingrese el nombre del jugador: ");
		            String nombre = entrada.nextLine();

		            System.out.print("Ingrese el apellido del jugador: ");
		            String apellido = entrada.nextLine();

		            // Buscar el jugador en el ArrayList
		            Jugador jugador = buscarJugador(nombre, apellido, jugadores);
		            if (jugador != null) {
		                System.out.println("\nDatos del jugador: ");
		                System.out.println("Nombre: " + jugador.getNombre() + " " + jugador.getApellido());
		                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
		                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
		                System.out.println("Estatura: " + jugador.getEstatura() + " cm");
		                System.out.println("Peso: " + jugador.getPeso() + " kg");
		                System.out.println("Posición: " + jugador.getPosicion());
		                System.out.println("Edad: " + jugador.calcularEdad() + " años");
		            } else {
		                System.out.println("Jugador no encontrado.");
		            }
		        } catch (Exception e) {
		            System.out.println("Error al mostrar los datos del jugador./n Motivo del Eror: " + e.getMessage());
		        }
		    }
			
		    
			public static Jugador buscarJugador(String nombre, String apellido, List<Jugador> jugadores) {       	
	            // Buscar jugador
	            System.out.println("\nBuscar por apellido y nombre:"+ apellido +" "+nombre);
	            for (Jugador jugador : jugadores) {
	            	if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
	            		return jugador;
	            	}
	            }
				return null;     
		    }
		
		    
			public static void modificarJugador(Scanner leerScanner, List<Jugador> jugadores) {
		    	Posicion posicion = null;
		    	
		    	try {
		    		
		            System.out.print("Ingrese el nombre del jugador que decea modificar: ");
		            String nombre = leerScanner.nextLine();

		            System.out.print("Ingrese el apellido del jugador que decea modificar: ");
		            String apellido = leerScanner.nextLine();

		            // Buscar el jugador en el ArrayList
		            Jugador jugador = buscarJugador(nombre, apellido, jugadores);
		            if (jugador != null) {
		                System.out.println("\nDatos del jugador a modificar: ");
		                
		                System.out.print("Ingrese el nuevo nombre del jugador : ");
		                String nombreMod = leerScanner.nextLine();
		                jugador.setNombre(nombreMod);
		                
		                System.out.print("Ingrese el nuevo apellido del jugador: ");
		                String apellidomod = leerScanner.nextLine();
		                jugador.setApellido(apellidomod);

		                System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
		                LocalDate fechaNacimiento = LocalDate.parse(leerScanner.nextLine());
		                jugador.setFechaNacimiento(fechaNacimiento);
		                

		                System.out.print("Ingrese la nueva nacionalidad del jugador: ");
		                String nacionalidad = leerScanner.nextLine();
		                jugador.setNacionalidad(nacionalidad);
		                
		                System.out.print("Ingrese la nueva estatura del jugador (en cm): ");
		                double estatura = leerScanner.nextDouble();
		                leerScanner.nextLine();
		                jugador.setEstatura(estatura);
		                

		                System.out.print("Ingrese el nuevo peso del jugador (en kg): ");
		                double peso = leerScanner.nextDouble();
		                leerScanner.nextLine();
		                jugador.setPeso(peso);
		                String op;                
		                do {
			            	System.out.print("Ingrese la posición del jugador (delantero, medio, defensa, arquero): ");
				            String opString = leerScanner.nextLine();
				            op = opString.toUpperCase();
				            switch (op) {
							case "DELANTERO": 
								posicion = Posicion.DELANTERO;
								break;
							case "MEDIO":
								posicion = Posicion.MEDIO;
								break;
							case "DEFENSA":
								posicion = Posicion.DEFENSA;
								break;
							case "ARQUERO":
								posicion = Posicion.ARQUERO;
								break;
							default:
								System.out.println("Opción no válida. Intente nuevamente.");
							}
						} while (!(op.equals("DELANTERO") || op.equals("MEDIO") || op.equals("DEFENSA") || op.equals("ARQUERO")));
		                jugador.setPosicion(posicion);
		                
		            } else {
		                System.out.println("Jugador no encontrado.");
		            }
		        } catch (Exception e) {
		            System.out.println("Error al mostrar los datos del jugador./n Motivo del Eror: Valores Incorrectos " + e.getMessage());
		        }
		        
		    }
		    
		    
			public static void eliminarJugador(Scanner leerScanner, List<Jugador> jugadores) {
		        
				 System.out.print("Ingrese el nombre del jugador que decea eliminar: ");
		         String nombre = leerScanner.nextLine();

		         System.out.print("Ingrese el apellido del jugador que decea eliminar: ");
		         String apellido = leerScanner.nextLine();
		         
		         Iterator<Jugador> iterator = jugadores.iterator();
		         while (iterator.hasNext()) {
		             Jugador jugador = iterator.next();
		             if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
		                 iterator.remove();
		                 System.out.println("Jugador eliminado correctamente.");
		                 return;
		             }
		         }
		         System.out.println("No se encontró un jugador con ese nombre y apellido.");
		        
		    }
		    
	
	
}
