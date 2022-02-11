package com.codingdojo.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.pokebook.models.PokeBook;

@Repository
public interface PokeBookRepo extends CrudRepository<PokeBook, Long>{
	List<PokeBook> findAll();

}
