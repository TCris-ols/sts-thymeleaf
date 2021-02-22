package com.tcristols.sellstest.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String descricao;
	private String categoria;
	private Integer codigo;
	private Double preco;
	
	
	public Produto() {

	}


	public Produto(String id, String descricao, String categoria, Integer codigo, Double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.codigo = codigo;
		this.preco = preco;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	


	
	
	

}
