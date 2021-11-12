package co.edu.unbosque.tiendavirtual1_back.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas implements Serializable{
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoventa;
	@ManyToOne
	@JoinColumn(name = "clientes_id", nullable = false)
	private Clientes cliente;
	@ManyToOne
	@JoinColumn(name = "usuarios_id", nullable = false)
	private Usuarios usuario;
	private long ivaventa;
	private long total_venta;
	private long valor_venta;
	@OneToMany(mappedBy = "venta1", cascade=CascadeType.ALL)
	private List<Detalleventas> detalle_ventas = new ArrayList<>();
	
	public Ventas() {
		super();
	}

	public Ventas(long codigoventa, Clientes cliente, Usuarios usuario, long ivaventa, long total_venta,
			long valor_venta) {
		super();
		this.codigoventa = codigoventa;
		this.cliente = cliente;
		this.usuario = usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	public long getCodigoventa() {
		return codigoventa;
	}
	public void setCodigoventa(long codigoventa) {
		this.codigoventa = codigoventa;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public long getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(long ivaventa) {
		this.ivaventa = ivaventa;
	}
	public long getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(long total_venta) {
		this.total_venta = total_venta;
	}
	public long getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(long valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	


}
