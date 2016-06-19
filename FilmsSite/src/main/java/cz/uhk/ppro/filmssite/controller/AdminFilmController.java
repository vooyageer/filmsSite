package cz.uhk.ppro.filmssite.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import cz.uhk.ppro.filmssite.dao.FilmDao;

import cz.uhk.ppro.filmssite.model.Film;

@Controller
public class AdminFilmController {

	
	private Path path;
	
	
	@Autowired
	private FilmDao filmDao;

	
	
	@RequestMapping("/admin/filmInventory") 
	public String filmInventory(Model model) {
		List<Film> films = filmDao.getAllFilms();
		model.addAttribute("films", films);
		
		
		return "filmInventory";
	}
	
	@RequestMapping("/admin/filmInventory/addFilm") 
	public String addFilm(Model model) {
		Film film = new Film();
		
		film.setPublished_year(1990);
		film.setCountry("...");
		film.setDescription("Lorem ipsum dolor sit amet, oratio partem ponderum his id, no soleat quidam audire pro. Ex ancillae torquatos eam, id mei postulant dignissim. Fierent partiendo eu mel, ex mel tota offendit. Ei vis voluptua adipiscing ullamcorper. Commune antiopam ea sed.");
		//film.setGender("muž");

		model.addAttribute("film", film);
		
		return "addFilm";
		
	}
	
	@RequestMapping(value = "/admin/filmInventory/addFilm", method = RequestMethod.POST)
	public String addFilmPost(@Valid @ModelAttribute("film") Film film, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addFilm";
		}
		
		
		filmDao.addFilm(film);
		
		MultipartFile filmImage = film.getFilmImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/films/" + "" +  film.getIdFilm() + ".png");
		

		System.out.println(path);
		
		if (filmImage != null && !filmImage.isEmpty()) {
			try {
				filmImage.transferTo(new File(path.toString()));
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
				throw new RuntimeException("Uložení obrázku se nepodařilo", e);
				
			}
		} 
		
		return "redirect:/admin/filmInventory";
	}
	
	
	@RequestMapping("/admin/filmInventory/deleteFilm/{id}") 
	public String deleteFilm(@PathVariable String id, Model model, HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/films/" + "" +  id + ".png");
		
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		filmDao.deleteFilm(id);
		
		return "redirect:/admin/filmInventory";
	}
	
	
	@RequestMapping("/admin/filmInventory/editFilm/{id}")
	public String editFilm(@PathVariable("id") String id, Model model) {
		Film film = filmDao.getFilmById(id);
		
		model.addAttribute(film);
		
		return "editFilm";
	}
	
	
	@RequestMapping(value ="/admin/filmInventory/editFilm/", method = RequestMethod.POST)
	public String editFilm(@Valid @ModelAttribute("film") Film film, Model model, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "editFilm";
		}
		
		
		MultipartFile filmImage = film.getFilmImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:/Dokumenty/WORKSPACE - web/filmsSite/src/main/webapp/resources/images/films/" + "" + film.getIdFilm()+ ".png");
		
		if (filmImage != null && !filmImage.isEmpty()) {
			try {
				filmImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Uložení obrázku se nepodařilo", e);
				
			}
		}
		
		filmDao.editFilm(film);
		
		
		return "redirect:/admin/filmInventory";
	}
	
	
	
}
