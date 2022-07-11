package hyber.service;

import hyber.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getOneUser(long id);
}
