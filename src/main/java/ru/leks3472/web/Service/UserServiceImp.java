package ru.leks3472.web.Service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leks3472.web.dao.UserDao;
import ru.leks3472.web.dao.UserDaoImp;
import ru.leks3472.web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
       this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}