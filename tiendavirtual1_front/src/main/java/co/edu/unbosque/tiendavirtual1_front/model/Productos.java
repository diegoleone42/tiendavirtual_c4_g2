package co.edu.unbosque.tiendavirtual1_front.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
	
	@Id
	@Column(unique = true, nullable = false)
	private long codigo_producto;
	private String nombre_producto;
	@ManyToOne
	@JoinColumn(name = "proveedores_id", nullable=false)
	private Proveedores proveedor;
	private long precio_compra;
	private long iva_compra;
	private long precio_venta;
	@OneToMany(mappedBy = "producto", cascade=CascadeType.ALL)
	private List<Detalleventas> detalle_ventas = new ArrayList<>();
	
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Productos(long codigo_producto, String nombre_producto, long nitproveedor, long precio_compra,
			long iva_compra, long precio_venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.proveedor = proveedor;
		this.precio_compra = precio_compra;
		this.iva_compra = iva_compra;
		this.precio_venta = precio_venta;
	}

	public long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}



	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	public long getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(long precio_compra) {
		this.precio_compra = precio_compra;
	}

	public long getIva_compra() {
		return iva_compra;
	}

	public void setIva_compra(long iva_compra) {
		this.iva_compra = iva_compra;
	}

	public long getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(long precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "{"
				+"\"codigo_producto\": "+ codigo_producto
				+", \"nombre_producto\": \""+ nombre_producto
				+"\", \"proveedor\": {"
										+"\"nit_proveedor\":"+ proveedor.getNit_proveedor()
										+", \"ciudad\":\""+ proveedor.getCiudad()
										+"\", \"nombre_proveedor\":\""+ proveedor.getNombre_proveedor()
										+"\", \"direccion_proveedor\":\""+ proveedor.getDireccion_proveedor()
										+"\", \"telefono_proveedor\":\""+ proveedor.getTelefono_proveedor()
										+"\"}"
				+", \"precio_compra\": "+ precio_compra
				+", \"iva_compra\": "+ iva_compra
				+", \"precio_venta\": "+ precio_venta
				+"}";
	}
}
