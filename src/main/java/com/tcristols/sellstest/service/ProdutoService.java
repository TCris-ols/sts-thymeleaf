package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Produto;
import com.tcristols.sellstest.model.Produto;

@Service
public interface ProdutoService {
	
	Optional<Produto> getProdutoByCodigo(String codigo);
	Optional<Produto> getProdutoByDescricao(String descricao);
	List<Produto> getAllProdutos();
	
	void deleteAllProdutos();
	void deleteProdutoByCodigo(String codigo);
	void updateProdutoByCodigo(String codigo, Produto produto);
	void updateProduto(Produto produto);
	void insertProduto(Produto produto);

}
