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

import co.edu.unbosque.tiendavirtual1_back.dao.DetalleventasDAO;
import co.edu.unbosque.tiendavirtual1_back.model.Detalleventas;

@RestController //esta es una clase REST
@RequestMapping(path="/detalleventas")
public class DetalleventasAPI {
	
	@Autowired //inyecta la dependencia de todos los mÃ©todos del JPA para usuarioDAO
	private DetalleventasDAO detalleventasDAO;
	
	@PostMapping(path="/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Detalleventas detalle_ventas) {
		detalleventasDAO.save(detalle_ventas);
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Detalleventas> listar(){
		return (List<Detalleventas>) detalleventasDAO.findAll();
	}

	@DeleteMapping(path="/eliminar")
	public void eliminar(@RequestBody Detalleventas detalle_ventas) {
		long id = detalle_ventas.getCodigo_detalle_venta();
		detalleventasDAO.deleteById(id);
	}

	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Detalleventas detalle_ventas) {
		detalleventasDAO.save(detalle_ventas);
	}
	
	@PostMapping(path="/consultar")
	public @ResponseBody Optional<Detalleventas> consultar(@RequestBody Detalleventas detalle_ventas) {
		Long codigo_detalle_venta = detalle_ventas.getCodigo_detalle_venta();
		return detalleventasDAO.findById(codigo_detalle_venta);
	}
}

