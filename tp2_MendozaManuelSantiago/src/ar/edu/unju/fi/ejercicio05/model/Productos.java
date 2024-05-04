package ar.edu.unju.fi.ejercicio05.model;

public class Productos {
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	private boolean stock;
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(int codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto:  Codigo= " + codigo + "-- Descripcion= " + descripcion + "-- PrecioUnitario= " + precioUnitario
				+ "-- OrigenFabricacion= " + origenFabricacion + "-- Categoria= " + categoria + "-- Stock: "+stock;
	}
	
	
}
