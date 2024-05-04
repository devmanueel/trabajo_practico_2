package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {
	private String nombre;
	private byte edad;
	private float peso;
	
	public FelinoDomestico() {
		// TODO Auto-generated constructor stub
	}

	
	
	public FelinoDomestico(String nombre, byte edad, float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
}
