package co.edu.unbosque.tiendavirtual1_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtual1_back.model.Detalleventas;

@Repository
public interface DetalleventasDAO extends JpaRepository<Detalleventas, Long>{

}
