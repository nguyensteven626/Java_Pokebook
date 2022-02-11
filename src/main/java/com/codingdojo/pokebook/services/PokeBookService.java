package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.pokebook.models.PokeBook;
import com.codingdojo.pokebook.repositories.PokeBookRepo;

@Service
public class PokeBookService {
	
	@Autowired
	private PokeBookRepo pokeBookRepo;
	
	public PokeBookService(PokeBookRepo pokeBookRepo) {
		this.pokeBookRepo = pokeBookRepo;
	}
	
	public List<PokeBook> allPokeBook() {
		return pokeBookRepo.findAll();
	}
		
	public PokeBook findPokeBook(Long id) {
		Optional<PokeBook> optionalPokeBook = pokeBookRepo.findById(id);
		if(optionalPokeBook.isPresent()) {
			return optionalPokeBook.get();
		} else {
			return null;
		}
	}
	
	public PokeBook createPokeBook(PokeBook expense) {
		return pokeBookRepo.save(expense);
	}
	
	public PokeBook updatePokeBook(Long id, PokeBook poke) {
		if(pokeBookRepo.findById(id).isPresent()) {
			PokeBook pokebook = pokeBookRepo.findById(id).get();
			
			pokebook.setAmount(poke.getAmount());
			pokebook.setExpense(poke.getExpense());
			pokebook.setVendor(poke.getVendor());
			pokebook.setDescription(poke.getDescription());
			
			return pokeBookRepo.save(pokebook);
		}
		return null;
	}
	
	public void deletePokeBook(Long id) {
		pokeBookRepo.deleteById(id);
	}

}
