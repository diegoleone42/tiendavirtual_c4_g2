package co.edu.unbosque.tiendavirtual1_back.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual1_back.dao.UsuariosDAO;
import co.edu.unbosque.tiendavirtual1_back.model.Usuarios;


@RestController //esta es una clase REST
@RequestMapping(path="/usuarios")
public class UsuariosAPI {
	
	@Autowired //inyecta la dependencia de todos los mÃ©todos del JPA para usuarioDAO
	private UsuariosDAO usuariosDAO;
	
	@PostMapping(path="/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Usuarios> listar(){
		return (List<Usuarios>) usuariosDAO.findAll();
	}

	@DeleteMapping(path="/eliminar")
	public void eliminar(@RequestBody Usuarios usuario) {
		long id = usuario.getCedula_usuario();
		usuariosDAO.deleteById(id);
	}

	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}
	
	@PostMapping(path="/login")
	public String login(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> a = usuariosDAO.findByUsuarioAndPassword(usuarios.getUsuario(), usuarios.getPassword());
		String status = new String();
		if (a.isPresent()) {
			status = "{\"status\":\"true\"}";
		}else {
			status = "{\"status\":\"false\"}";
		}
		return status;
	}
	
	@PostMapping(path="/consultar")
	public @ResponseBody Optional<Usuarios> consultar(@RequestBody Usuarios usuarios) {
		Long cedula_usuario = usuarios.getCedula_usuario();
		return usuariosDAO.findById(cedula_usuario);
	}
	
	@PostMapping(path="/traerid")
	public @ResponseBody Usuarios traerid(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> a = usuariosDAO.findByUsuarioAndPassword(usuarios.getUsuario(), usuarios.getPassword());
		if (a.isPresent()) {
			return a.get();
		}else {
			Usuarios c = new Usuarios();
			return c;
		}
	}
}
