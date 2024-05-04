package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagodo;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagodo) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagodo = montoPagodo;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public LocalDate getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}


	public double getMontoPagodo() {
		return montoPagodo;
	}


	public void setMontoPagodo(double montoPagodo) {
		this.montoPagodo = montoPagodo;
	}


	

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		montoPagodo=monto+(monto*0.15);
	}
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		LocalDate fechaHoy = LocalDate.now();
		this.numeroTarjeta = "198223123";
		this.fechaPago= fechaHoy;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Fecha de pago:' dd/MM/yy");
		System. out.println("***** Pago con tarjeta: *****");
	    System.out.println("Número de tarjeta: " + numeroTarjeta);
	    String fechaFormateada = fechaHoy.format(formato);
	    System.out.println(fechaFormateada);
	    System.out.println("Monto pagado: " + montoPagodo);
	}
	
}
