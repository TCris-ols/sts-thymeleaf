package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Produto;
import com.tcristols.sellstest.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public List<Produto> getAllProdutos() {
		return  (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public void deleteAllProdutos() {
		
		produtoRepository.deleteAll();
	}


	@Override
	public void updateProdutoByCodigo(String codigo, Produto produto) {
		Optional<Produto> getProduto = getProdutoByCodigo(codigo);
		getProduto.get().setDescricao(produto.getDescricao());	
		getProduto.get().setPreco(produto.getPreco());
		getProduto.get().setCategoria(produto.getCategoria());
	}


	public Optional<Produto> getProdutoByCodigo(String codigo) {
		
		return produtoRepository.findByCodigo(codigo);
	}

	@Override
	public void updateProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	@Override
	public void insertProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void deleteProdutoByCodigo(String codigo) {
		produtoRepository.deleteByCodigo(codigo);
		
	}
	

	@Override
	public Optional<Produto> getProdutoByDescricao(String descricao) {

		return produtoRepository.getProdutoByDescricao(descricao);
	}


	
}
