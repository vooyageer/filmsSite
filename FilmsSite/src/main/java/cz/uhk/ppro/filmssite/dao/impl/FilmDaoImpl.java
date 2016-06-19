package cz.uhk.ppro.filmssite.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.model.Film;

@Repository
@Transactional
public class FilmDaoImpl implements FilmDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(film);
		session.flush();
		
	}

	@Override
	public void editFilm(Film film) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(film);
		session.flush();
		
	}

	@Override
	public Film getFilmById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Film film = (Film) session.get(Film.class, id);
		session.flush();
		
	    return film;
	}

	@Override
	public List<Film> getAllFilms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Film");
		@SuppressWarnings("unchecked")
		List<Film> films = query.list();
		session.flush();
		
		return films;
	}

	@Override
	public void deleteFilm(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getFilmById(id));
		session.flush();
		
	}
	
}
