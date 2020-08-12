package br.com.cast.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.avaliacao.model.Category;
import br.com.cast.avaliacao.repository.CategoryRopository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRopository repository;
	
	@Override
	public List<Category> findAll() {
		return (List<Category>) repository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return  repository.findById(id).get() ;
	}
	
}
