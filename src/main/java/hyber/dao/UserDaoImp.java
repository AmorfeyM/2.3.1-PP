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
    public void removeUserById(long id) {
        entityManager.createQuery("delete from User user where user.id = :userID")
                .setParameter("userID", id).executeUpdate();
    }
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getOneUser(long id) {
        List<User> users =  entityManager.createQuery("select user from User user where user.id = :userID", User.class)
                .setParameter("userID", id)
                .getResultList();
        return users.stream().findAny().orElse(null);
    }


}
