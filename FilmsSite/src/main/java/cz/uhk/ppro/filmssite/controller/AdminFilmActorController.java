package cz.uhk.ppro.filmssite.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cz.uhk.ppro.filmssite.dao.ActorDao;
import cz.uhk.ppro.filmssite.dao.FilmActorDao;
import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.model.Actor;
import cz.uhk.ppro.filmssite.model.Film;
import cz.uhk.ppro.filmssite.model.FilmActor;

@Controller
public class AdminFilmActorController {

	
	@Autowired
	private ActorDao actorDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private FilmActorDao filmActorDao;
	
	
	// ModelAttribute pro select box
	@ModelAttribute("filmsall")
	public Collection<Film> populateFilms() {	
		return this.filmDao.getAllFilms();
	}
	
	@ModelAttribute("actorsall")
	public Collection<Actor> populateActors() {	
		return this.actorDao.getAllActors();
	}
	
	
	@RequestMapping("/admin/filmActorInventory") 
	public String filmActorInventory(Model model) {
		List<FilmActor> filmActors = filmActorDao.getAllFilmActors();
		model.addAttribute("filmActors", filmActors);
		
		
		return "filmActorInventory";
	}

	
	@RequestMapping("/admin/filmActorInventory/addFilmActor") 
	public String addFilmActor(Model model) {
		FilmActor filmActor = new FilmActor();
		
		model.addAttribute("filmActor", filmActor);
		
		
		return "addFilmActor";
		
	}
	
	@RequestMapping(value = "/admin/filmActorInventory/addFilmActor", method = RequestMethod.POST)
	public String addFilmActorPost(@Valid @ModelAttribute("filmActor") FilmActor filmActor, BindingResult result, HttpServletRequest request) {
		System.out.println("tady? ");
		if(result.hasErrors()) {
			return "addFilmActor";
			
		}
		
		
		filmActorDao.addFilmActor(filmActor);
		
		
		return "redirect:/admin/filmActorInventory";
	}
	
	

	

	
}
