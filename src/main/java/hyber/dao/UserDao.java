package hyber.dao;

import hyber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getOneUser(long id);



}
