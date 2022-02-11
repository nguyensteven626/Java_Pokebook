package com.codingdojo.pokebook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.pokebook.models.PokeBook;
import com.codingdojo.pokebook.services.PokeBookService;

@Controller
public class HomeController {
	
	@Autowired
	private PokeBookService service;
	public HomeController(PokeBookService pokeBookService) {
		this.service = pokeBookService;
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("exp") PokeBook expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", service.allPokeBook());
			return "home.jsp";
		} else {
			service.createPokeBook(expense);
			return "redirect:/expenses";
		}
	}
	
	
	@RequestMapping("/expenses")
	public String home(@ModelAttribute("expense") PokeBook expense, Model model) {
		model.addAttribute("expenses", service.allPokeBook());
		return "home.jsp";
	}
		
		
	@RequestMapping("/expenses/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		PokeBook expense = service.findPokeBook(id);
		model.addAttribute("expense", expense);
		return "detail.jsp";
	}
	
	
	@RequestMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		PokeBook expense = service.findPokeBook(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
//	method=RequestMethod.POST
	@PutMapping(value="/expenses/{id}")
	public String update(@Valid @PathVariable("id") Long id, @ModelAttribute("exp") PokeBook expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			service.updatePokeBook(id, expense);
			return "redirect:/expenses";
		}
	}
	
	// Delete
	@DeleteMapping(value="/expenses/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		service.deletePokeBook(id);
		return "redirect:/expenses";
	}

}
