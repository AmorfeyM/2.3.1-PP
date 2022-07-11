package hyber.service;

import hyber.dao.UserDao;
import hyber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   @Transactional
   public void removeUser(Long id) {
      userDao.removeUser(id);
   }
   @Override
   @Transactional
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   public User getOneUser(long id) {
      return userDao.getOneUser(id);
   }

}
