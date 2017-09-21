package com.citting.dao;


import com.citting.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    //ADD USER
    public User addUser(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    //UPDATE
    public	void update(User	entity)	{
        entityManager.merge(entity);
    }

    //REMOVE

    public void remove(User entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    //SHOW ALL

    public List<User> getList(){
        Query query = entityManager.createQuery("SELECT b FROM User b");
        List<User> users = query.getResultList();
        return users;
    }
    // FIND USER BY ID

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public boolean checkifExsist(String loginOrEmail)
    {
        List<User> list= getList();

        for(User user:list)
        {
            if(user.getEmail().equals(loginOrEmail)||user.getLogin().equals(loginOrEmail))
            {
                return true;
            }
        }
        return false;
    }





}
