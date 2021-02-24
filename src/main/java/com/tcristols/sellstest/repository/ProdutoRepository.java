package com.tcristols.sellstest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcristols.sellstest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByCodigo(String codigo);

	void deleteByCodigo(String codigo);

	Optional<Produto> getProdutoByDescricao(String descricao);

}
