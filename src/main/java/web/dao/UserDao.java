package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();
    User getUserById(int id);
    void updateUser(User user);
    void removeById(int id);
    void saveUser(User user);
}
