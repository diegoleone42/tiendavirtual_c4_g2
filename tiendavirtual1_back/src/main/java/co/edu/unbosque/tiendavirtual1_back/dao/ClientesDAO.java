package co.edu.unbosque.tiendavirtual1_back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtual1_back.model.Clientes;

@Repository
public interface ClientesDAO extends JpaRepository<Clientes, Long>{
	
	@Query(value="SELECT clientes.cedula_cliente, clientes.nombre_cliente, SUM(ventas.total_venta) FROM clientes join ventas on (clientes.cedula_cliente = ventas.clientes_id) group by cedula_cliente", nativeQuery = true)
	List<List<String>> funcion();
		
}