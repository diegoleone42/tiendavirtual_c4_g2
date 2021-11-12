package co.edu.unbosque.tiendavirtual1_front.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "proveedores")
public class Proveedores {
	
	@Id
	@Column(unique = true, nullable = false)
	private long nit_proveedor;
	private String nombre_proveedor;
	private String ciudad;
	private String direccion_proveedor;
	private long telefono_proveedor;
	@OneToMany(mappedBy="proveedor", cascade=CascadeType.ALL)
	private List<Productos> productos = new ArrayList<>();
	
	
	public Proveedores() {
		super();
		
	}

	
	public Proveedores(long nit_proveedor, String nombre_proveedor, String ciudad, String direccion_proveedor,
			long telefono_proveedor) {
		super();
		this.nit_proveedor = nit_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.ciudad = ciudad;
		this.direccion_proveedor = direccion_proveedor;
		this.telefono_proveedor = telefono_proveedor;
	}
	
	public long getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}
	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}
	public long getTelefono_proveedor() {
		return telefono_proveedor;
	}
	public void setTelefono_proveedor(long telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}


	@Override
	public String toString() {
		return  "{"
				+"\"nit_proveedor\":"+ nit_proveedor
				+", \"ciudad\":\""+ ciudad
				+"\", \"nombre_proveedor\":\""+ nombre_proveedor
				+"\", \"direccion_proveedor\":\""+ direccion_proveedor
				+"\", \"telefono_proveedor\":\""+ telefono_proveedor
				+"\"}";
	}
	
}
