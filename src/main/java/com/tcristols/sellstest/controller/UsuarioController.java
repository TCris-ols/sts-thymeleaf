package com.tcristols.sellstest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tcristols.sellstest.model.Usuario;
import com.tcristols.sellstest.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value= "/insert", method = RequestMethod.GET)
	public ModelAndView insert() {
		return new ModelAndView("insert", "usuario", new Usuario());
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String submitInsert(@Validated @ModelAttribute("usuario") Usuario  usuario, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		 
		usuarioService.insertUsuario(usuario);
		
		return "redirect:";
	}
	
	@RequestMapping(value= "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {
		return new ModelAndView("delete", "usuario", usuarioService.getUsuarioById(id).get());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String submitDelete(@Validated @ModelAttribute("usuario") Usuario  usuario, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		usuarioService.deleteUsuarioById(usuario.getId());
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

		return new ModelAndView("update", "usuario", usuarioService.getUsuarioById(id).get());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdate(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		usuarioService.updateUsuario(usuario);

		return "redirect:";
	}
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("read");
		mav.addObject("usuarios", usuarioService.getAllUsuarios());
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("usuarios", usuarioService.getAllUsuarios());
		return mav;
	}
}
