package springmvc.hibernate.bookstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.hibernate.bookstore.Dao.UserDao;
import springmvc.hibernate.bookstore.Entity.User;

@Service
public class UserService implements UserDao{

	
	@Autowired
	private UserDao userDao;
	
	public User isUserExists(String name, String password) {
		return userDao.isUserExists(name, password);
	}

	public boolean registerUser(User user) {
		return userDao.registerUser(user);
	}

}
