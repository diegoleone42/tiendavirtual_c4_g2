package co.edu.unbosque.tiendavirtual1_back.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual1_back.dao.ProductosDAO;
import co.edu.unbosque.tiendavirtual1_back.model.Productos;


@RestController //esta es una clase REST
@RequestMapping(path="/productos")
public class ProductosAPI {
	
	@Autowired //inyecta la dependencia de todos los mÃ©todos del JPA para ProveedoresDAO
	private ProductosDAO productosDAO;

	@PostMapping(path="/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Productos productos) {
		productosDAO.save(productos);
	}
	
	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Productos> listar(){
		return (List<Productos>) productosDAO.findAll();
	}

	@PostMapping(path="/consultar")
	public @ResponseBody Optional<Productos> consultar(@RequestBody Productos productos) {
		Long codigo_producto = productos.getCodigo_producto();
		return productosDAO.findById(codigo_producto);
	} 

}
