package co.edu.unbosque.tiendavirtual1_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtual1_back.model.Proveedores;

@Repository
public interface ProveedoresDAO extends JpaRepository<Proveedores, Long>{
}
