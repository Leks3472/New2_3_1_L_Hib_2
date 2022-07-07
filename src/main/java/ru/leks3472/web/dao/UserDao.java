package ru.leks3472.web.dao;

import ru.leks3472.web.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
