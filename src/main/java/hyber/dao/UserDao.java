package hyber.dao;

import hyber.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getOneUser(long id);
}
