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
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@Column(unique = true, nullable = false)
	private long cedula_usuario;
	private String nombre_usuario;
	private String email_usuario;
	@Column(unique = true)
	private String usuario;
	private String password;
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Ventas> productos = new ArrayList<>();
	
	
	public Usuarios() {
		super();
	}
	
	
	
	public Usuarios(long cedula_usuario, String nombre_usuario, String email_usuario, String usuario, String password) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.nombre_usuario = nombre_usuario;
		this.email_usuario = email_usuario;
		this.usuario = usuario;
		this.password = password;
	}



	public long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "{"
				+"\"cedula_usuario\":"+ cedula_usuario
				+", \"nombre_usuario\":\""+ nombre_usuario
				+"\" , \"email_usuario\":\""+ email_usuario
				+"\" , \"usuario\":\""+ usuario
				+"\" , \"password\":\""+ password
				+"\"}";
	}
	
	
}
