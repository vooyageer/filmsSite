package cz.uhk.ppro.filmssite.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film_actor")
public class FilmActor {
	
	@Id
    @GeneratedValue
    @Column(name = "idfilm_actor")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Film_idFilm")
    private Film film;
    
	@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Actor_idActor")
    private Actor actor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	
	
	

}
