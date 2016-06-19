package cz.uhk.ppro.filmssite.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Table(name="actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idActor;
	
	@NotEmpty(message = "Jméno musí být vyplněno.")
	private String name;
	private String description;
	
	@Min(value = 0, message="Rok narození musí být kladné číslo.")
	private Integer born_year;
	private String gender;
	private String country;
	
	@Transient
	private MultipartFile actorImage;
	
	@OneToMany(mappedBy = "actor")
	private Set<FilmActor> filmActor = new HashSet<FilmActor>();
	
	public Actor() {
		
	}
	
	public Actor(String name, String description, Integer born_year, String gender, String country) {
		this.name = name;
		this.description = description;
		this.born_year = born_year;
		this.gender = gender;
		this.country = country;
	}
	
	
	
	
	public Integer getIdActor() {
		return idActor;
	}
	public void setIdActor(Integer idActor) {
		this.idActor = idActor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBorn_year() {
		return born_year;
	}
	public void setBorn_year(Integer born_year) {
		this.born_year = born_year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public MultipartFile getActorImage() {
		return actorImage;
	}

	public void setActorImage(MultipartFile actorImage) {
		this.actorImage = actorImage;
	}

	public Set<FilmActor> getFilmActor() {
		return filmActor;
	}

	public void setFilmActor(Set<FilmActor> filmActor) {
		this.filmActor = filmActor;
	}



	
}
