package cz.uhk.ppro.filmssite.dao;

import java.util.List;

import cz.uhk.ppro.filmssite.model.Film;

public interface FilmDao {

	
	void addFilm(Film film);
	
	void editFilm(Film film);
	
	Film getFilmById(String idFilm);
	
	List<Film> getAllFilms();
	
	void deleteFilm(String id);
}
