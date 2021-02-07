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
	public Optional<Usuario> getUsuarioById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void deleteAllUsuario() {
		
		usuarioRepository.deleteAll();
	}

	@Override
	public void deleteUsuarioById(Integer id) {
		
		usuarioRepository.deleteById(id);
	}

	@Override
	public void updateUsuarioById(Integer id, Usuario usuario) {
		Optional<Usuario> getUsuario = getUsuarioById(id);
		getUsuario.get().setUsername(usuario.getUsername());	
		getUsuario.get().setSenha(usuario.getSenha());
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
