package ar.edu.unju.fi.ejercicio02.util;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class MetodosMain {
	
	public MetodosMain() {
		// TODO Auto-generated constructor stub
	}
	
	
	// son los metodos por el cual hacemos las operaciones del MENU DE EFEMERIDE
	public static void crearEfemeride(Scanner entrada, List<Efemeride> efemerides) {
        try {
            System.out.print("Ingrese el Codigo de efemeride: ");
            int codigo = entrada.nextInt();
            entrada.nextLine(); 
            //solicita el ingreso de datos para meses
            Mes m = meses(entrada);
            //solicita el ingreso del dias entre 1 y 31
            int dia = ingresoDias(entrada);
            entrada.nextLine();
            System.out.println("Ingrese Detalles: ");
            String descripcionString = entrada.nextLine();
            System.out.println("Efemeride creado Correctamente.");
            System.out.println(descripcionString);
            
            Efemeride efemeride = new Efemeride(codigo, m, dia, descripcionString);
 
            efemerides.add(efemeride);
        } catch (Exception e) {
            System.out.println("Error al crear la efemeride.\n Motivo del Eror: Datos incorrectos");
            entrada.nextLine();
        }
	}
	
	public static Mes meses(Scanner entrada) {
		Mes efemeride =null;
		int mes = 0;
		 do {
			System.out.print("Ingrese mes (solo ingrese numeros del 1 - 12): ");
			mes = entrada.nextInt();
			try {
					switch (mes) {
			            case 1:
			            	efemeride = Mes.ENERO;
			                break;
			            case 2:
			            	efemeride = Mes.FEBRERO;
			                break;
			            case 3:
			            	efemeride = Mes.MARZO;
			                break;
			            case 4:
			            	efemeride = Mes.ABRIL;
			                break;
			            case 5:
			            	efemeride = Mes.MAYO;
			                break;
			            case 6:
			            	efemeride = Mes.JUNIO;
			                break;
			            case 7:
			            	efemeride = Mes.JULIO;
			                break;
			            case 8:
			            	efemeride = Mes.AGOSTO;
			                break;
			            case 9:
			            	efemeride = Mes.SEPTIEMBRE;
			                break;
			            case 10:
			            	efemeride = Mes.OCTUBRE;
			                break;
			            case 11:
			            	efemeride = Mes.NOVIEMBRE;
			                break;
			            case 12:
			            	efemeride = Mes.DICIEMBRE;
			                break;
			            default:
			                System.out.println("Opción no válida. Intente nuevamente.\nIngrese Numeros entre 1 y 12 ");
				}
			
		    entrada.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Se esperaba un número entero.");
	        entrada.nextLine();
		}
	} while ( !( mes >=1 && mes <= 12 ) );
		 
	 return efemeride; 
	 
	 
	}
	
	public static int ingresoDias(Scanner entrada) {
		int dia = 0;
		do {
			try {
				System.out.print("Ingrese dia: "); 
				dia = entrada.nextInt();
				if (dia>31) {
				System.out.println("Ingrese nuevamente los dias del 1 al 31");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Se esperaba un número entero.");
		        entrada.nextLine();
			}
		} while (! (dia >=1 && dia <=31));
		return dia;
	}
	
	
	public static void mostrarEfemerides(List<Efemeride> efemerides) {
    	if (efemerides.isEmpty()) {
            System.out.println("No hay Efemerides.");
        } else {
            for (Efemeride efemeride : efemerides) {
                System.out.println(efemeride);
            }
        }
    }
	
	
	// ELIMINARA
	public static void eliminarEfemeride(List<Efemeride> efemerides, Scanner scanner) {
	    	
    	try {
    	if (efemerides.isEmpty()) {
            System.out.println("No hay Efemerides para borrar.");
            return;
        }
    	System.out.println("-------------------------------------------------------");
    	System.out.println("Ingrese el código de una Efemeride que desea eliminar:");
        int codigoEfemeride = scanner.nextInt();
        Iterator<Efemeride> iter = efemerides.iterator();
        while (iter.hasNext()) {
            Efemeride efemeride = iter.next();
            if (efemeride.getCodigo() == codigoEfemeride) {
                iter.remove();
                System.out.println("Efemeride eliminado correctamente.");
                return;
            }
        }
        System.out.println("El destino turístico no existe.");
        
	    } catch (InputMismatchException e) {
	        System.out.println("Error al ingresar datos. Asegúrese de ingresar el tipo de dato correcto.");
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error: " + e.getMessage());
	    }
    
    }
	 
	 
	 //MODIFICAION
	 
	 public static void modificarEfemeride(Scanner leerScanner, List<Efemeride> efemerides) {
	    	try {
	    		
	            System.out.print("Ingrese codigo de la Efemeride: ");
	            int codigo = leerScanner.nextInt();

	            // Buscar el jugador en el ArrayList
	            Efemeride efemeride = buscarEfemeride(codigo, efemerides);
	            if (efemeride != null) {
	                System.out.println("\nDatos de la nueva Efemeride a modificar: ");
	                
	                System.out.print("Ingrese el nuevo codigo de efemeride : ");
	                int cod = leerScanner.nextInt();
	                efemeride.setCodigo(cod);
	                
	                System.out.print("Ingrese el nuevo mes: ");
	                Mes m = meses(leerScanner);
	                efemeride.setMes(m);;

	                System.out.print("Ingrese el nuevo dia: ");
	                int dia = ingresoDias(leerScanner);
	                efemeride.setDia(dia);
	                leerScanner.nextLine();

	                System.out.print("Ingrese El nuevo detalle de la Efemeride: ");
	                String detalle = leerScanner.nextLine();
	                efemeride.setDetalle(detalle);
	                               
	            } else {
	                System.out.println("Jugador no encontrado.");
	            }
	        } catch (Exception e) {
	            System.out.println("Error al mostrar los datos del jugador./n Motivo del Eror: " + e.getMessage());
	        }
	        
	    }
	 
	 
	 private static Efemeride buscarEfemeride(int cod, List<Efemeride> efemerides) {       	
         // Buscar Efemeride
         System.out.println("\nBuscar por codgo de Efemerde:");
         for (Efemeride efemeride : efemerides) {
         	if (efemeride.getCodigo()==cod) {
         		return efemeride;
         	}
         }
			return null;     
	}
	
}
