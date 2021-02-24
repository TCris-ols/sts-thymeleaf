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

import com.tcristols.sellstest.model.Produto;
import com.tcristols.sellstest.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	  @RequestMapping(value= "/novoproduto", method = RequestMethod.GET) public
	  ModelAndView insert() { 
		  return new ModelAndView("novoproduto", "produto", new Produto()); 
		  }
	 	
	@RequestMapping(value = "/novoproduto", method = RequestMethod.POST)
	public String submitInsert(@Validated @ModelAttribute("produto") Produto  produto, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		produtoService.insertProduto(produto);
		
		return null;
	}
	
	@RequestMapping(value= "/deleteptoduto", method = RequestMethod.GET)
	public ModelAndView delete(String codigo) {
		return new ModelAndView("deleteproduto", "produto", produtoService.getProdutoByCodigo(codigo));
	}
	
	@RequestMapping(value = "/deleteptoduto", method = RequestMethod.POST)
	public String submitDelete(@Validated @ModelAttribute("produto") Produto  produto, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "error";
		}
		produtoService.deleteProdutoByCodigo(produto.getCodigo());
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/updateproduto", method = RequestMethod.GET)
	public ModelAndView update(String codigo) {

		return new ModelAndView("updateproduto", "produto", produtoService.getProdutoByCodigo(codigo));
	}

	@RequestMapping(value = "/updateproduto", method = RequestMethod.POST)
	public String submitUpdate(@Validated @ModelAttribute("produto") Produto produto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		produtoService.updateProduto(produto);

		return "redirect:";
	}
	@RequestMapping(value = "/readproduto", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("read");
		mav.addObject("produtos", produtoService.getAllProdutos());
		return mav;
	}
	
	
	@RequestMapping(value= "/codigo", method = RequestMethod.GET)
	public ModelAndView codigo(String codigo) {
		return new ModelAndView("codigo", "produto", produtoService.getProdutoByCodigo(codigo));
	}

	}
