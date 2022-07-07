package hyber.service;

import hyber.model.User;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {
    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getOneUser(long id);
}
