package co.edu.unbosque.tiendavirtual1_back.model;

public class Reporte {
	
	private long cedula_cliente;
	private String nombre_cliente;
	private long valor_total;
	
	public Reporte(long cedula_cliente, String nombre_cliente, long valor_total) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.valor_total = valor_total;
	}
	
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public long getValor_total() {
		return valor_total;
	}
	public void setValor_total(long valor_total) {
		this.valor_total = valor_total;
	}

	@Override
	public String toString() {
		return "{\"cedula_cliente\": " + cedula_cliente
				+ ", \"nombre_cliente\": \"" + nombre_cliente
				+ "\", \"valor_total\": "+ valor_total
				+ "}";
	}
	
	
	

}
