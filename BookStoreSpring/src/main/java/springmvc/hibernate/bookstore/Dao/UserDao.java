package springmvc.hibernate.bookstore.Dao;

import springmvc.hibernate.bookstore.Entity.User;

public interface UserDao {

	User isUserExists(String name, String password);
	
	boolean registerUser(User user);
}
