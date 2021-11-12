package co.edu.unbosque.tiendavirtual1_back.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtual1_back.model.Clientes;
import co.edu.unbosque.tiendavirtual1_back.model.Ventas;

@Repository
public interface VentasDAO extends JpaRepository<Ventas, Long>{
	
	Ventas findTopByOrderByCodigoventaDesc();
}
