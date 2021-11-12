package co.edu.unbosque.tiendavirtual1_back.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleventas")
public class Detalleventas implements Serializable{
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo_detalle_venta;
	private int cantidad_producto;
	@ManyToOne
	@JoinColumn(name = "productos_id", nullable=false)
	private Productos producto;
	@ManyToOne
	@JoinColumn(name = "ventas_id", nullable=false)
	private Ventas venta1;
	private long valor_total;
	private long valor_venta;
	private long valoriva;
	
	public Detalleventas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Detalleventas(long codigo_detalle_venta, int cantidad_producto, Productos producto, Ventas venta1,
			long valor_total, long valor_venta, long valoriva) {
		super();
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.producto = producto;
		this.venta1 = venta1;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}

	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Ventas getVenta1() {
		return venta1;
	}

	public void setVenta1(Ventas venta1) {
		this.venta1 = venta1;
	}

	public long getValor_total() {
		return valor_total;
	}

	public void setValor_total(long valor_total) {
		this.valor_total = valor_total;
	}

	public long getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(long valor_venta) {
		this.valor_venta = valor_venta;
	}

	public long getValoriva() {
		return valoriva;
	}

	public void setValoriva(long valoriva) {
		this.valoriva = valoriva;
	}
	
	

}
