package com.citting.dao;

import com.citting.entity.Question;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class QuestionDao {

    @PersistenceContext
    EntityManager entityManager;

    public Question addQuestion(Question entity) {
        entityManager.persist(entity);
        return entity;
    }

    public	void update(Question	entity)	{
        entityManager.merge(entity);
    }

    public void remove(Question entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Question> getList(){
        Query query = entityManager.createQuery("SELECT b FROM Question b");
        List<Question> places = query.getResultList();
        return places;
    }
    public Question findById(long id) {
        return entityManager.find(Question.class, id);
    }

}
