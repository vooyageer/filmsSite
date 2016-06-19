package cz.uhk.ppro.filmssite.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.filmssite.dao.FilmActorDao;
import cz.uhk.ppro.filmssite.model.Film;
import cz.uhk.ppro.filmssite.model.FilmActor;

@Repository
@Transactional
public class FilmActorDaoImpl implements FilmActorDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addFilmActor(FilmActor filmActor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(filmActor);
		session.flush();
		
	}

	@Override
	public void editFilmActor(FilmActor filmActor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(filmActor);
		session.flush();
		
	}

	@Override
	public FilmActor getFilmActorById(String id) {
		Session session = sessionFactory.getCurrentSession();
		FilmActor filmActor = (FilmActor) session.get(FilmActor.class, id);
		session.flush();
		
	    return filmActor;
	}

	@Override
	public List<FilmActor> getAllFilmActors() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FilmActor");
		@SuppressWarnings("unchecked")
		List<FilmActor> filmActors = query.list();
		session.flush();
		
		return filmActors;
	}

	@Override
	public void deleteFilmActor(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getFilmActorById(id));
		session.flush();
		
	}

}
