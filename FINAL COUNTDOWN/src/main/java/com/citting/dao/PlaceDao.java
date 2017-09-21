package com.citting.dao;

import com.citting.entity.Place;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PlaceDao {

    @PersistenceContext
    EntityManager entityManager;

    public Place addPlace(Place entity) {
        entityManager.persist(entity);
        return entity;
    }

    public	void update(Place	entity)	{
        entityManager.merge(entity);
    }

    public void remove(Place entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Place> getList(){
        Query query = entityManager.createQuery("SELECT b FROM Place b");
        List<Place> places = query.getResultList();
        return places;
    }
    public Place findById(long id) {
        return entityManager.find(Place.class, id);
    }



}
