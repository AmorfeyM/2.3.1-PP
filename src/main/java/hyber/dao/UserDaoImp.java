package hyber.dao;

import hyber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImp implements UserDao {

   @PersistenceContext(unitName = "em")
   private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    @Transactional
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
