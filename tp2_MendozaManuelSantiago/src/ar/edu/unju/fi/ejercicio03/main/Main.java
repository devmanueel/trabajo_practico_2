package ar.edu.unju.fi.ejercicio03.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//aray para guardar las densidades de las provincias pedidadas  
		List densidList =new ArrayList();
		
		for (Provincia provincia : Provincia.values()) {
			densidList.add("----------------------------------------------------");
			densidList.add("Provincia: "+ provincia.name());
			densidList.add("Poblacion: "+ provincia.getPOBLACION()+ " habitantes");
			densidList.add("Superficie: "+ provincia.getSUPERFICIE()+" km^2");
			densidList.add("Densidad: " +provincia.calcularDensidadPoblacional() +" km^2");
		}
		
		System.out.println("************Elementos de la lista:************");
        for (int i = 0; i < densidList.size(); i++) {
            System.out.println(densidList.get(i));
        }
		
	}
}