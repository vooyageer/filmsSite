package cz.uhk.ppro.filmssite.dao;

import java.util.List;

import cz.uhk.ppro.filmssite.model.FilmActor;

public interface FilmActorDao {
	
	void addFilmActor(FilmActor filmActor);
	
	void editFilmActor(FilmActor filmActor);
	
	FilmActor getFilmActorById(String id);
	
	List<FilmActor> getAllFilmActors();
	
	void deleteFilmActor(String id);

}
