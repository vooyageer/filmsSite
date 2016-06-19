package cz.uhk.ppro.filmssite.service;

import java.util.List;


public interface GenericService<E, K> {
    public void saveOrUpdate(E entity);

    public List<E> getAll();

    public E get(K id);

    public Integer add(E entity);

    public void update(E entity);

    public void remove(E entity);
}
