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

import co.edu.unbosque.tiendavirtual1_back.dao.VentasDAO;
import co.edu.unbosque.tiendavirtual1_back.model.Clientes;
import co.edu.unbosque.tiendavirtual1_back.model.Ventas;

@RestController //esta es una clase REST
@RequestMapping(path="/ventas")
public class VentasAPI {
	
	@Autowired //inyecta la dependencia de todos los mÃ©todos del JPA para usuarioDAO
	private VentasDAO ventasDAO;
	
	@PostMapping(path="/guardar")//Request convierte en un objeto Java desde un JSon
	public @ResponseBody long guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
		return ventasDAO.findTopByOrderByCodigoventaDesc().getCodigoventa();
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Ventas> listar(){
		return (List<Ventas>) ventasDAO.findAll();
	}

	@DeleteMapping(path="/eliminar")
	public void eliminar(@RequestBody Ventas ventas) {
		long id = ventas.getCodigoventa();
		ventasDAO.deleteById(id);
	}

	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}

	
	@PostMapping(path="/consultar")
	public @ResponseBody Optional<Ventas> consultar(@RequestBody Ventas ventas) {
		Long codigo_venta = ventas.getCodigoventa();
		return ventasDAO.findById(codigo_venta);
	}
	
}
