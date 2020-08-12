package br.com.cast.avaliacao.service;

import java.util.List;

import br.com.cast.avaliacao.model.Category;

public interface ICategoryService {

	public List<Category> findAll();

	public Category findById(Long id);

}
