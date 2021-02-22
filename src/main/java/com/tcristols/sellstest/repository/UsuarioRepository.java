package com.tcristols.sellstest.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcristols.sellstest.model.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	void deleteByLogin(String login);
	Optional<Usuario> findByLogin(String login);
}
