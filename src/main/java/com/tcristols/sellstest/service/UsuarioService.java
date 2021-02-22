package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Usuario;

@Service
public interface UsuarioService {
	
	Optional<Usuario> getUsuarioByLogin(String login);
	List<Usuario> getAllUsuarios();
	
	void deleteAllUsuario();
	void deleteUsuarioByLogin(String login);
	void updateUsuarioByLogin(String login, Usuario usuario);
	void updateUsuario(Usuario usuario);
	void insertUsuario(Usuario usuario);

}
