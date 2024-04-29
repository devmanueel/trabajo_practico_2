package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//aray para guardar las densidades de las provincias pedidadas  
		Provincia [] procProvincias = Provincia.values();
		//muestra de datos
		for (Provincia provincia : procProvincias) {
			System.out.println("************ PROVINCIA: ************");
			System.out.println("Provincia: "+ provincia.name());
			System.out.println("Poblacion: "+ provincia.getPOBLACION()+ " Habitantes");
			System.out.println("Superficie: "+ provincia.getSUPERFICIE()+" km^2");
			System.out.println("Densidad: " +provincia.calcularDensidadPoblacional() +" km^2");
		}
		
	}
}