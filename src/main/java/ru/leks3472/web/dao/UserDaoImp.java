package ru.leks3472.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.leks3472.web.models.User;


import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToBeUpdated = session.get(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}