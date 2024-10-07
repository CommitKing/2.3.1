package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(User user);

    User findById(int id);

    List<User> getAllUsers();

    User updateUserInfo(User user, User existingUser);
}
