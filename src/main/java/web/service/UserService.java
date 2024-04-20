package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUserById(int id);
    void updateUser(User user);
    void removeById(int id);
    void saveUser(User user);
}
