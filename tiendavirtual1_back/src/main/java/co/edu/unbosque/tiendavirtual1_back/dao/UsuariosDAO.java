package co.edu.unbosque.tiendavirtual1_back.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtual1_back.model.Usuarios;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuarios, Long>{
	Optional<Usuarios> findByUsuarioAndPassword(String usuario, String password);

}
