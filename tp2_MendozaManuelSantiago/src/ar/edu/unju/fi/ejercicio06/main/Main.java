package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//realizamos la conversion de ubjeto de felino salvaje a felino domestico
		FelinoSalvaje felinoSalvaje=new FelinoSalvaje("Tanner", (byte)20, 186);
		//FelinoSalvaje felinoPruevaSalvaje = null; PARA PROBAR EN CASO DE NULL
		boolean notNull = Converter.IsNotNull(felinoSalvaje);
		if (notNull == true){
			Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),
				x.getEdad(), x.getPeso());
			FelinoDomestico felino1 = converter.convert(felinoSalvaje);
			converter.mostrarObjeto(felino1);
		}else {
			System.out.println("Objeto a convertir es Nulo");
		}
		
		
	}

}
