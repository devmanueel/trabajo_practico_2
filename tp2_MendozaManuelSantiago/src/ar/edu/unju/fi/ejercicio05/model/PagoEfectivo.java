package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagodo;
	private LocalDate fechaPagoDate;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PagoEfectivo(double montoPagodo, LocalDate fechaPagoDate) {
		this.montoPagodo = montoPagodo;
		this.fechaPagoDate = fechaPagoDate;
	}

	
	
	public double getMontoPagodo() {
		return montoPagodo;
	}


	public void setMontoPagodo(double montoPagodo) {
		this.montoPagodo = montoPagodo;
	}


	public LocalDate getFechaPagoDate() {
		return fechaPagoDate;
	}


	public void setFechaPagoDate(LocalDate fechaPagoDate) {
		this.fechaPagoDate = fechaPagoDate;
	}


	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		montoPagodo = monto-(monto* 0.10);
	}
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		LocalDate fechHoy = LocalDate.now();
		this.fechaPagoDate= fechHoy;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Fecha de pago:' dd/MM/yy");
		System. out.println("***** Pago con tarjeta: *****");
		System.out.println("***** Se efectuo el pago en efectivo: *****");
        String fechaFormateada = fechHoy.format(formato);
	    System.out.println(fechaFormateada);
        System.out.println("Monto pagado: " + montoPagodo);
	}
	
	
}
