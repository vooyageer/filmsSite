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
import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.model.Actor;
import cz.uhk.ppro.filmssite.model.Film;

@Controller
public class AdminController {
	
	private Path path;
	
	@Autowired
	private ActorDao actorDao;
	
	@Autowired
	private FilmDao filmDao;
	
	
	// ModelAttribute pro select box
		@ModelAttribute("filmsall")
		public Collection<Film> populateRooms() {	
			return this.filmDao.getAllFilms();
		}
	

	@RequestMapping("/admin") 
	public String adminPage(ModelMap modelMap) {
		modelMap.put("action", "admin");	
		return "admin";
	}
	
	@RequestMapping("/admin/actorInventory") 
	public String actorInventory(Model model) {
		List<Actor> actors = actorDao.getAllActors();
		model.addAttribute("actors", actors);
		
		
		return "actorInventory";
	}
	
	@RequestMapping("/admin/actorInventory/addActor") 
	public String addActor(Model model) {
		Actor actor = new Actor();
		
		actor.setBorn_year(1990);
		actor.setCountry("CZ");
		actor.setDescription("Lorem ipsum dolor sit amet, oratio partem ponderum his id, no soleat quidam audire pro. Ex ancillae torquatos eam, id mei postulant dignissim. Fierent partiendo eu mel, ex mel tota offendit. Ei vis voluptua adipiscing ullamcorper. Commune antiopam ea sed.");
		actor.setGender("muž");

		model.addAttribute("actor", actor);
		
		return "addActor";
		
	}
	
	@RequestMapping(value = "/admin/actorInventory/addActor", method = RequestMethod.POST)
	public String addActorPost(@Valid @ModelAttribute("actor") Actor actor, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addActor";
		}
		
		
		actorDao.addActor(actor);
		
		MultipartFile actorImage = actor.getActorImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/" + "" +  actor.getIdActor() + ".png");
		

		System.out.println(path);
		
		if (actorImage != null && !actorImage.isEmpty()) {
			try {
				actorImage.transferTo(new File(path.toString()));
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
				throw new RuntimeException("Uložení obrázku se nepodařilo", e);
				
			}
		} 
		
		return "redirect:/admin/actorInventory";
	}
	
	
	@RequestMapping("/admin/actorInventory/deleteActor/{id}") 
	public String deleteActor(@PathVariable String id, Model model, HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/" + "" +  id + ".png");
		
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		actorDao.deleteActor(id);
		
		return "redirect:/admin/actorInventory";
	}
	
	
	@RequestMapping("/admin/actorInventory/editActor/{id}")
	public String editActor(@PathVariable("id") String id, Model model) {
		Actor actor = actorDao.getActorById(id);
		
		model.addAttribute(actor);
		
		return "editActor";
	}
	
	
	@RequestMapping(value ="/admin/actorInventory/editActor/", method = RequestMethod.POST)
	public String editActor(@Valid @ModelAttribute("actor") Actor actor, Model model, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "editActor";
		}
		
		
		MultipartFile actorImage = actor.getActorImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/" + "" + actor.getIdActor()+ ".png");
		
		if (actorImage != null && !actorImage.isEmpty()) {
			try {
				actorImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Uložení obrázku se nepodařilo", e);
				
			}
		}
		
		actorDao.editActor(actor);
		
		
		return "redirect:/admin/actorInventory";
	}
	

}
