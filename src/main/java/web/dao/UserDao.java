package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(User user);

    User findById(int id);

    List<User> getAllUsers();

    //User getUserByParameter
}
