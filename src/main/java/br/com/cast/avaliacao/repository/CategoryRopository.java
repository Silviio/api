package br.com.cast.avaliacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cast.avaliacao.model.Category;

@Repository
public interface CategoryRopository extends CrudRepository<Category, Long> {

}
