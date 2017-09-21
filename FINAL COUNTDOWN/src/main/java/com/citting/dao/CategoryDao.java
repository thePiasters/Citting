package com.citting.dao;

import com.citting.entity.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public	void update(Category entity)	{
        entityManager.merge(entity);
    }


    public List<Category> getList(){
        Query query = entityManager.createQuery("SELECT b FROM Category b");
        List<Category> categories = query.getResultList();
        return categories;
    }
    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public Category addCategory(Category entity) {
        entityManager.persist(entity);
        return entity;
    }
    public void remove(Category entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
