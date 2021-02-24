package com.tcristols.sellstest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcristols.sellstest.model.Categoria;
import com.tcristols.sellstest.service.CategoriaService;

@RestController
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	
	@RequestMapping(value = "rest/getAllCategoria", method = RequestMethod.GET)
	public List<Categoria> getCategorias(){
		return categoriaService.getAllCategorias();
	}
	
	@RequestMapping(value = "rest/getCategoria/{id}", method = RequestMethod.GET)
	public Optional<Categoria> getCategoria(@PathVariable("id") Integer id){
		return categoriaService.getCategoriaById(id);
	}
	
	
	@RequestMapping(value = "rest/insertCategoria", method = RequestMethod.POST)
	public void insertCategoria(@RequestBody Categoria categoria) {
		categoriaService.insertCategoria(categoria);
	}
	
	@RequestMapping(value = "/rest/deleteAllCategorias", method = RequestMethod.DELETE)
	public void deleteCategorias() {
		categoriaService.deleteAllCategorias();
	}

	@RequestMapping(value = "/rest/deleteCategoria/{id}", method = RequestMethod.DELETE)
	public void deleteCategoria(@PathVariable("id") Integer id) {
		categoriaService.deleteCategoriaById(id);
	}
	
}
