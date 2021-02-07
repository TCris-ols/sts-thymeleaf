package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Usuario;

@Service
public interface UsuarioService {
	
	Optional<Usuario> getUsuarioById(Integer id);
	
	List<Usuario> getAllUsuarios();
	
	void deleteAllUsuario();
	void deleteUsuarioById(Integer id);
	void updateUsuarioById(Integer id, Usuario usuario);
	void updateUsuario(Usuario usuario);
	void insertUsuario(Usuario usuario);

}
