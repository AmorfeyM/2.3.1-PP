package hyber.service;

import hyber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getOneUser(long id);
}
