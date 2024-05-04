package ar.edu.unju.fi.ejercicio05.util;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Productos;
import ar.edu.unju.fi.ejercicio05.model.Productos.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Productos.OrigenFabricacion;

public class MetodosMain {
	public static void cargaProductos(List<Productos> productos) {
		Productos producto1 = new Productos(1111, "Lavadora", 150.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Productos producto2 = new Productos(2222, "Estufa	", 200.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Productos producto3 = new Productos(3333, "Refrigerado", 300.99, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false);
		Productos producto4 = new Productos(4444, "Secadora", 350.99, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true);
		Productos producto5 = new Productos(5555, "Microondas", 400.99, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false);
		Productos producto6 = new Productos(6666, "Licuadora", 500.00, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true);
		Productos producto7 = new Productos(7777, "Cafetera", 500.00, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Productos producto8 = new Productos(8888, "Aspiradora", 600.99, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Productos producto9 = new Productos(9999, "Televisor", 800.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false);
		Productos producto10 = new Productos(1010, "Equipo de sonido", 1500.99, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false);
		Productos producto11 = new Productos(1101, "Reproductor de DVD", 950.99, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false);
		Productos producto12 = new Productos(1212, "Consola de videojuegos", 1150.99, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true);
		Productos producto13 = new Productos(1313, "Consola de videojuegos", 1250.99, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true);
		Productos producto14 = new Productos(1414, "Teléfono inteligente", 1250.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Productos producto15 = new Productos(1515, "Termostato", 100.00, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);
		productos.add(producto9);
		productos.add(producto10);
		productos.add(producto11);
		productos.add(producto12);
		productos.add(producto13);
		productos.add(producto14);
		productos.add(producto15);
	}
	
	public static void compra(Scanner leerscaner,List<Productos> productos){
		double sumaPredcios = 0.0;
		if(productos.isEmpty()) {
			System.out.println("Primero Vea los productos a Comprar. Luego realize la compra: ");	
		}else {
			
			boolean band2 = true;
			while (band2==true) {
	            System.out.println("Ingrese el código del producto para comprar (o '0' para salir): ");
	            int codigo = leerscaner.nextInt();
	            
	            if (codigo == 0) {
	            	band2=false;
	                break; // Salir del bucle si se ingresa 0
	            } 
	            
	            boolean encontrado = false;
	            
	            for (Productos producto : productos) {
	                if (producto.getCodigo() == codigo) {
	                    System.out.println("Producto encontrado: " + producto.getDescripcion());
	                    encontrado = true;
	                    sumaPredcios=sumaPredcios+producto.getPrecioUnitario();
	                    break;
	                }
	            }
	            
	            if (!encontrado) {//es para verificar si el producto existe o no
	                System.out.println("El producto con el código ingresado no existe.");
	            }
	        }
			System.out.println("Saliendo de la gondola de productos: ");
			System.out.println("****TOTAL: "+sumaPredcios+"*******");
			
			mostrarOpcionesPago(leerscaner, sumaPredcios);
		}
		
	}
	
	
	
	//se muestra los productos
	 public static void mostrarProductos(List<Productos> productos) {
             for (Productos product : productos) {
            	 if (product.isStock()==true) {
            		 System.out.println(product);
            	 }
            	
             }
             
     }
	 
	 //mostramos opciones de pago
	 public static void mostrarOpcionesPago(Scanner scanner, double monto) {
		        boolean opcionValida = false;

		        while (!opcionValida) {
		            try {
		                System.out.println("Opciones de pago:");
		                System.out.println("1 - Pago efectivo");
		                System.out.println("2 - Pago con tarjeta");
		                System.out.print("Ingrese su opción de pago: ");
		                int opcionPago = scanner.nextInt();

		                switch (opcionPago) {
		                    case 1:
		                        System.out.println("Ha seleccionado pago en efectivo.");
		                        opcionValida = true;
		                        // Lógica para procesar pago en efectivo
		                        PagoEfectivo pagoEfectivo = new PagoEfectivo();
		                        pagoEfectivo.realizarPago(monto);
		                        pagoEfectivo.imprimirRecibo();
		                        break;
		                    case 2:
		                        System.out.println("Ha seleccionado pago con tarjeta.");
		                        opcionValida = true;
		                        PagoTarjeta pagoTarjeta = new PagoTarjeta();
		                        pagoTarjeta.realizarPago(monto);
		                        pagoTarjeta.imprimirRecibo();
		                        break;
		                    default:
		                        System.out.println("Opción de pago inválida. Por favor, ingrese 1 o 2.");
		                }
		            } catch (Exception e) {
		                System.out.println("Ha ocurrido un error. Por favor, ingrese una opción válida.");
		                scanner.next(); // Limpiar el búfer del scanner
		            }
		        }
		    }
}
