package hyber.dao;

import hyber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));

    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getOneUser(long id) {
        return entityManager.find(User.class, id);
    }


}
