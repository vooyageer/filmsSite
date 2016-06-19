package cz.uhk.ppro.filmssite.dao;

import java.util.List;

import cz.uhk.ppro.filmssite.model.Actor;

public interface ActorDao {

	
	void addActor(Actor actor);
	
	void editActor(Actor actor);
	
	Actor getActorById(String id);
	
	List<Actor> getAllActors();
	
	void deleteActor(String id);
}
