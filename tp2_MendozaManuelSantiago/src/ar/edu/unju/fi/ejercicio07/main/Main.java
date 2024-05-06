package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio05.model.Productos.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Productos;
import ar.edu.unju.fi.ejercicio05.model.Productos.OrigenFabricacion;

public class Main {
	
	private static List<Productos> productos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productos= new ArrayList<>();
		preCargaProductos(productos);
		
		Scanner leer = new Scanner(System.in);
		int opcion;
     	do {
     		try {
	            System.out.println("*********** MENU ***********");
	            System.out.println("1 - Mostrar productos");
	            System.out.println("2 - Mostrar los Productos Faltantes");
	            System.out.println("3 - Incrementar los precios en un 20%");
	            System.out.println("4 - Mostrar los productos Electrohogar disponibles");
	            System.out.println("5 - Ordenar los productos por precio de forma descendente.");
	            System.out.println("6 - Mostrar los productos con los nombres en mayúsculas. ");
	            System.out.println("7 - Salir");
	            System.out.print("Ingrese su opción: ");
	            opcion = leer.nextInt();
	
	            switch (opcion) {
	                case 1:
	                    System.out.println("Mostrando productos...");
	                    mostrarProductos();
	                	
	                    break;
	                case 2:
	                    System.out.println("Productos Faltantes");
	                    mostrarProductosFaltantes();
	                    	
	                    break;
	                case 3:
	                	System.out.println("Precios Incrementados en un 20%");
	                	incrementarPrecio();
	                	break;
	                case 4:
	                	System.out.println("Productos Electro Hogar ");
	                	mostrarProductosElectroHogar();
	                	break;
	                case 5:
	                	System.out.println("Productos Ordenados Decrecientemente: ");
	                	ordenarProductosDecendente();
	                	break;
	                case 6:
	                	productosMayusculas();
	                	break;
	                case 7:
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
	        
	    } while (opcion != 7);
	    leer.close();
		
	}
	//MOSTRAR PRODUCTOS CON CONSUMER
	public static void mostrarProductos() {
		Consumer<Productos> printConsumer = p -> {
			if (p.isStock()) 
            System.out.println(p);
		};
		
		productos.forEach(printConsumer);
		
	}
	// MOSTRAR PROFUCTO FALTANTES
	//USO DE PREDICATE
	public static void mostrarProductosFaltantes() {
		Predicate<Productos> filterEstadoFalse = p-> !p.isStock(); //estoy negando para que me devuelva los valores en FALSO
		productos.stream().filter(filterEstadoFalse).forEach(System.out::println);
		
	}
	
	//INCREMENTO DE PRECIOS EN UN 20%
	public static void incrementarPrecio() {
		Function<Productos, Productos> functionIncrementar = (p)->{
			double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.2f);
			p.setPrecioUnitario(resultado);
			return p;
		};
		List<Productos> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream().map(functionIncrementar).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
	}
	
	//MOSTRAMOS PRODUCTOS DE la CATEGORIA ELECTROHOGAR
	public static void mostrarProductosElectroHogar() {
		Predicate<Productos> filterElectroHogar = p-> p.getCategoria() == Categoria.ELECTROHOGAR && p.isStock();; 
		productos.stream().filter(filterElectroHogar).forEach(System.out::println);
		
	}
	//MOSTRAMOS LOS PODUCTOS ORDENADOS DE MANERA DECRECIENTE POR PRECIOS
	public static void ordenarProductosDecendente() {
		productos.sort(Comparator.comparing(Productos::getPrecioUnitario).reversed());
        productos.forEach(p -> System.out.println(p));
	}
	

	 //CONVIERTE EN MAYUSCULA LA DESCIOCION DE CADA PRODUCTO
	public static void productosMayusculas() {
		Function<Productos, Productos> functionProductosMayusculas = (z)->{
			String nombresEnMayusculas = z.getDescripcion().toUpperCase();
			z.setDescripcion(nombresEnMayusculas);
			return z;
		};
		List<Productos> nombresMayusculas = new ArrayList<>();
		nombresMayusculas = productos.stream().map(functionProductosMayusculas).collect(Collectors.toList());
		nombresMayusculas.forEach(System.out::println);
	}
	 
	
	// PRECARGA DE PRODUCTOS 
	public static void preCargaProductos(List<Productos> productos) {
		if(productos.isEmpty()) {
			productos.add(new Productos(1, "Maus", 150.99, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
			productos.add(new Productos(2, "Lavadora", 200.00, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
			productos.add(new Productos(3, "Notebook", 300.99, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
			productos.add(new Productos(4, "SANSUNG S23", 400.99, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true));
			productos.add(new Productos(5, "Pico", 500.99, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
			productos.add(new Productos(6, "Refrigerador", 600.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
			productos.add(new Productos(7, "Memoria", 700.99, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
			productos.add(new Productos(8, "MOTOROLA EDGE 30", 800.99, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
			productos.add(new Productos(9, "BALDE", 900.99, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
			productos.add(new Productos(10, "Metro", 1000.99, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
			productos.add(new Productos(11, "Licuadora", 1500.99, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false));
			productos.add(new Productos(12, "Termostato", 1200.99, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
			productos.add(new Productos(13, "TECLADO", 1300.99, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
			productos.add(new Productos(14, "SANSUNG A013", 1400.99, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
			productos.add(new Productos(15, "MONITOR", 1500.99, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
		}
	}

}
