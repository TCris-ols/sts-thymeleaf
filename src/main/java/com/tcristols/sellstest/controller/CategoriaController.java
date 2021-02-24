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

import com.tcristols.sellstest.model.Categoria;
import com.tcristols.sellstest.service.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	  @RequestMapping(value= "/novacategoria", method = RequestMethod.GET) public
	  ModelAndView insert() { 
		  return new ModelAndView("novacategoria", "categoria", new Categoria()); 
		  }
	 	
	@RequestMapping(value = "/novacategoria", method = RequestMethod.POST)
	public String submitInsert(@Validated @ModelAttribute("categoria") Categoria  categoria, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		categoriaService.insertCategoria(categoria);
		
		return "novacategoria";
	}
	
	@RequestMapping(value= "/deletecategoria", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {
		return new ModelAndView("deletecategoria", "categoria", categoriaService.getCategoriaById(id));
	}
	
	@RequestMapping(value = "/deletecategoria", method = RequestMethod.POST)
	public String submitDelete(@Validated @ModelAttribute("categoria") Categoria  categoria, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		categoriaService.deleteCategoriaById(categoria.getId());
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/updatecategoria", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

		return new ModelAndView("updatecategoria", "categoria", categoriaService.getCategoriaById(id));
	}

	@RequestMapping(value = "/updatecategoria", method = RequestMethod.POST)
	public String submitUpdate(@Validated @ModelAttribute("categoria") Categoria categoria, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		categoriaService.updateCategoria(categoria);

		return "redirect:";
	}
	
	@RequestMapping(value = "/readcategoria", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("readcategoria");
		mav.addObject("categorias", categoriaService.getAllCategorias());
		return mav;
	}
	
	
	@RequestMapping(value= "/idcategoria", method = RequestMethod.GET)
	public ModelAndView id(Integer id) {
		return new ModelAndView("id", "categoria", categoriaService.getCategoriaById(id));
	}

	}
