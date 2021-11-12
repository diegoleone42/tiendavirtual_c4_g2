package co.edu.unbosque.tiendavirtual1_back.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual1_back.dao.ProveedoresDAO;
import co.edu.unbosque.tiendavirtual1_back.model.Proveedores;

@RestController //esta es una clase REST
@RequestMapping(path="proveedores")

public class ProveedoresAPI {
	
	@Autowired //inyecta la dependencia de todos los mÃ©todos del JPA para ProveedoresDAO
	private ProveedoresDAO proveedoresDAO;
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}

	@GetMapping("/listar")
	public  @ResponseBody Iterable<Proveedores> listar(){
		return (List<Proveedores>) proveedoresDAO.findAll();
	}

	@DeleteMapping(path="/eliminar")
	public void eliminar(@RequestBody Proveedores proveedores) {
		long id = proveedores.getNIT_proveedor();
		proveedoresDAO.deleteById(id);
	}

	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}

	@PostMapping(path="/consultar")
	public @ResponseBody Optional<Proveedores> consultar(@RequestBody Proveedores proveedores) {
		Long NIT_proveedor = proveedores.getNIT_proveedor();
		return proveedoresDAO.findById(NIT_proveedor);
	}
	
}
