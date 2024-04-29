package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private String posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, double estatura,
			double peso, String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNac) {
		this.fechaNacimiento = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int calcularEdad() {
		
		LocalDate fechaActual = LocalDate.now();
        int anios = fechaActual.getYear() - fechaNacimiento.getYear();
        int meses = fechaActual.getMonthValue() - fechaNacimiento.getMonthValue();
        int dias = fechaActual.getDayOfMonth() - fechaNacimiento.getDayOfMonth();

        if (meses < 0 || (meses == 0 && dias < 0)) {
            anios--;
        }

        return anios;

	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNacimiento + "]";
	}
}
