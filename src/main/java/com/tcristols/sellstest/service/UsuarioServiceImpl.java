package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Usuario;
import com.tcristols.sellstest.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	

	@Override
	public List<Usuario> getAllUsuarios() {
		return  (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void deleteAllUsuario() {
		
		usuarioRepository.deleteAll();
	}


	@Override
	public void updateUsuarioByLogin(String login, Usuario usuario) {
		Optional<Usuario> getUsuario = getUsuarioByLogin(login);
		getUsuario.get().setNomeCompleto(usuario.getNomeCompleto());	
		getUsuario.get().setSenha(usuario.getSenha());
	}


	public Optional<Usuario> getUsuarioByLogin(String login) {
		
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void insertUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuarioByLogin(String login) {
		usuarioRepository.deleteByLogin(login);
		
	}


	
}
