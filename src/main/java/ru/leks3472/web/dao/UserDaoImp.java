package ru.leks3472.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.leks3472.web.models.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {

        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {

        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {

        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {

        entityManager.merge(updatedUser);


    }

    @Transactional
    @Override
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}