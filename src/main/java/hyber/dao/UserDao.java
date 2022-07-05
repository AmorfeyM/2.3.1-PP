package hyber.dao;

import hyber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getOneUser(long id);



}
