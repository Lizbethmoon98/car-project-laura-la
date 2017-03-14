package tech.tarragona.spring.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.tarragona.spring.model.Coche;
import tech.tarragona.spring.repository.CocheRepository;
import tech.tarragona.spring.service.CocheService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CocheService cocheService;
	@Autowired
	CocheRepository cocheRepository;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping
	public String home(Model model) {

		long productCount = cocheRepository.count();
		logger.info("productCount: " + productCount);
		
		return "home";
	}
	
	@GetMapping(value = "/listar")
	public String listarCoches(Model model) {
		model.addAttribute("coches", cocheService.listarCoches());
		return "listar";
				
	}
	
	@GetMapping("/crear")
	public String addPerson(Model model) {
		model.addAttribute("coche", new Coche());
		return "crear";
	}

	/*
	 * ADD PERSON AND PEOPLE REDIRECT
	 */
	@PostMapping("/crear")
	public String addPerson(@ModelAttribute("coche") Coche coche, BindingResult result, Model model) {
	
			cocheService.crearCoche(coche);
			return "home";	
		}
}
