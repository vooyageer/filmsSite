package cz.uhk.ppro.filmssite.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.filmssite.dao.ActorDao;
import cz.uhk.ppro.filmssite.model.Actor;

@Repository
@Transactional
public class ActorDaoImpl implements ActorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addActor(Actor actor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(actor);
		session.flush();
		
	}
	
	public void editActor(Actor actor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(actor);
		session.flush();
		
	}

	@Override
	public Actor getActorById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Actor actor = (Actor) session.get(Actor.class, id);
		session.flush();
		
		return actor;
	}

	@Override
	public List<Actor> getAllActors() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Actor");
		@SuppressWarnings("unchecked")
		List<Actor> actors = query.list();
		session.flush();
		
		return actors;
	}

	@Override
	public void deleteActor(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getActorById(id));
		session.flush();
	}
	
	

	
	

}
