package com.tcristols.sellstest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcristols.sellstest.model.Usuario;
import com.tcristols.sellstest.service.UsuarioService;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	
	@RequestMapping(value = "rest/getAll", method = RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return usuarioService.getAllUsuarios();
	}
	
	@RequestMapping(value = "rest/get/{login}", method = RequestMethod.GET)
	public Optional<Usuario> getUsuario(@PathVariable("login") String login){
		return usuarioService.getUsuarioByLogin(login);
	}
	
	
	@RequestMapping(value = "rest/insert", method = RequestMethod.POST)
	public void insertUsuario(@RequestBody Usuario usuario) {
		usuarioService.insertUsuario(usuario);
	}
	
	@RequestMapping(value = "/rest/deleteAll", method = RequestMethod.DELETE)
	public void deleteUsuarios() {
		usuarioService.deleteAllUsuario();
	}

	@RequestMapping(value = "/rest/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUsuario(@PathVariable("id") String id) {
		usuarioService.deleteUsuarioByLogin(id);
	}
	
}
