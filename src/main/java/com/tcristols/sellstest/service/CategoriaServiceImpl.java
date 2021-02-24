package com.tcristols.sellstest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcristols.sellstest.model.Categoria;
import com.tcristols.sellstest.repository.CategoriaRepository;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> getAllCategorias() {
		return   categoriaRepository.findAll();
	}

	@Override
	public void deleteAllCategorias() {
		
		categoriaRepository.deleteAll();
	}

	@Override
	public Optional<Categoria> getCategoriaById(Integer id) {
		
		return categoriaRepository.findById(id);
	}
	
	@Override
	public void updateCategoriaById(Integer id, Categoria categoria) {
		Optional<Categoria> getCategoria = getCategoriaById(id);
		getCategoria.get().setDescricao(categoria.getDescricao());	
	
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	@Override
	public void insertCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void deleteCategoriaById(Integer id) {
		categoriaRepository.deleteById(id);
		
	}

	
}
