package cz.uhk.ppro.filmssite.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Table(name="film")
public class Film {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idFilm;
	
	@NotEmpty(message = "Jméno musí být vyplněno.")
	private String name;
	private String description;
	
	@Min(value = 0, message="Rok narození musí být kladné číslo.")
	private int published_year;
	
	private int length;
	
	private String country;
	
	@Transient
	private MultipartFile filmImage;
	
	//@OneToOne(fetch = FetchType.LAZY, mappedBy = "film", cascade = CascadeType.ALL)
	private int prize;
	
	@OneToMany(mappedBy = "film")
	private Set<FilmActor> filmActor = new HashSet<FilmActor>();
	
	public Film() {

	}

	public Film(String name, String description, Integer published_year, int length, String country,
			MultipartFile filmImage, int prize) {
		this.name = name;
		this.description = description;
		this.published_year = published_year;
		this.length = length;
		this.country = country;
		this.filmImage = filmImage;
		this.prize = prize;
	}

	public String getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(String idFilm) {
		this.idFilm = idFilm;
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



	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public MultipartFile getFilmImage() {
		return filmImage;
	}

	public void setFilmImage(MultipartFile filmImage) {
		this.filmImage = filmImage;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public Set<FilmActor> getFilmActor() {
		return filmActor;
	}

	public void setFilmActor(Set<FilmActor> filmActor) {
		this.filmActor = filmActor;
	}



	
	
	

	
	
	
}
