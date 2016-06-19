package cz.uhk.ppro.filmssite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cz.uhk.ppro.filmssite.service.FilmService;
import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.dao.GenericDao;
import cz.uhk.ppro.filmssite.model.Film;
import cz.uhk.ppro.filmssite.model.Film;



@Service
public class FilmServiceImpl extends GenericServiceImpl<Film, Integer> implements FilmService {

	private FilmDao filmDao;
	
	public FilmServiceImpl(){
	}
	
	//@Autowired
	public FilmServiceImpl(@Qualifier("addressDaoImpl") GenericDao<Film, Integer> genericDao){
		super(genericDao);
		this.filmDao = (FilmDao) genericDao;
		
	}
}
