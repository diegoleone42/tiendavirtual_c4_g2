package co.edu.unbosque.tiendavirtual1_front.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {
	
	@Id
	@Column(unique = true, nullable = false)
	private long cedula_cliente;
	private String nombre_cliente;
	private String email_cliente;
	private String direccion_cliente;
	private long telefono_cliente;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Ventas> ventas = new ArrayList<>();
	
	
	public Clientes() {
		super();
		
	}

	public Clientes(long cedula_cliente, String nombre_cliente, String email_cliente, String direccion_cliente,
			long telefono_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.email_cliente = email_cliente;
		this.direccion_cliente = direccion_cliente;
		this.telefono_cliente = telefono_cliente;
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
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public long getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(long telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	@Override
	public String toString() {
		return "{"
				+"\"cedula_cliente\":"+ cedula_cliente
				+", \"email_cliente\":\""+ email_cliente
				+"\", \"nombre_cliente\":\""+ nombre_cliente
				+"\", \"direccion_cliente\":\""+ direccion_cliente
				+"\", \"telefono_cliente\":\""+ telefono_cliente
				+"\"}";
	}

	

}
