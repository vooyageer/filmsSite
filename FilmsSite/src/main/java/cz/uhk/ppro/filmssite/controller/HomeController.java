package cz.uhk.ppro.filmssite.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.model.Actor;
import cz.uhk.ppro.filmssite.model.Film;

@Controller
public class HomeController {
	
	
	
	@Autowired
	private ActorDao actorDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@RequestMapping("/")
	public String Home(Model model, ModelMap modelMap) {
		modelMap.put("action", "home");	
		List<Actor> actors = actorDao.getAllActors();
		//Actor actor = actorList.get(0);
		int size = actors.size();
		
		Random random = new Random();
		if (size > 0) {
		int nahodnecislo = random.nextInt(size);
		int nahodnecislo2 = random.nextInt(size);
		int nahodnecislo3 = random.nextInt(size);
		
		
		if (size >= 3) {
			while (nahodnecislo2 == nahodnecislo) {
				nahodnecislo2 = random.nextInt(size);
			}
			while (nahodnecislo3 == nahodnecislo || nahodnecislo3 == nahodnecislo2) {
				nahodnecislo3 = random.nextInt(size);
			}
		}
			

		
		Actor actor1 = actors.get(nahodnecislo);
		model.addAttribute("actor1", actor1);
		
		nahodnecislo = random.nextInt(size);
		Actor actor2 = actors.get(nahodnecislo2);
		model.addAttribute("actor2", actor2);
		
		nahodnecislo = random.nextInt(size);
		Actor actor3 = actors.get(nahodnecislo3);
		model.addAttribute("actor3", actor3);
		
		}
		
		
		return "home";
	}
	
	
	@RequestMapping("/actorList") 
	public String getActors(Model model, ModelMap modelMap) {
		modelMap.put("action", "herci");	
		List<Actor> actors = actorDao.getAllActors();
		//Actor actor = actorList.get(0);
		
		model.addAttribute("actors", actors);
		
		return "actorList";
	}
	
	@RequestMapping("/actorList/viewActor/{actorId}") 
	public String viewActor(@PathVariable String actorId, Model model, ModelMap modelMap) throws IOException{
		modelMap.put("action", "herci");
		Actor actor = actorDao.getActorById(actorId);
		
		model.addAttribute(actor);
		
		return "viewActor";
	}
	
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/filmList") 
	public String getFilms(Model model, ModelMap modelMap) {
		modelMap.put("action", "filmy");	
		List<Film> films = filmDao.getAllFilms();
		//Actor actor = actorList.get(0);
		
		model.addAttribute("films", films);
		
		return "filmList";
	}
	
	@RequestMapping("/filmList/viewFilm/{filmId}") 
	public String viewFilm(@PathVariable String filmId, Model model, ModelMap modelMap) throws IOException{
		modelMap.put("action", "filmy");
		Film film = filmDao.getFilmById(filmId);
		
		model.addAttribute(film);
		
		return "viewFilm";
	}
	
	
}
