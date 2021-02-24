package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Categoria;


@Service
public interface CategoriaService {
	
	Optional<Categoria> getCategoriaById(Integer id);
	List<Categoria> getAllCategorias();
	
	void deleteAllCategorias();
	void deleteCategoriaById(Integer id);
	void updateCategoriaById(Integer id, Categoria categoria);
	void updateCategoria(Categoria categoria);
	void insertCategoria(Categoria categoria);

}
