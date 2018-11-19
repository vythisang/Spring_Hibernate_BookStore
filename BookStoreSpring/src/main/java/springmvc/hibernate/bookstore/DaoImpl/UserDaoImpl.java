package springmvc.hibernate.bookstore.DaoImpl;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.hibernate.bookstore.Dao.UserDao;
import springmvc.hibernate.bookstore.Entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public User isUserExists(String name, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		String sql  = new String("from User where name= :name and password= :password");
		Query query = session.createQuery(sql,User.class);
		query.setParameter("name", name);
		query.setParameter("password", password);
		
		try{
			User user = (User) query.getSingleResult();
			if(user != null){
				return user;
			}
		}catch (NoResultException e) {
			return null;
		}
		return null;
		
		
	}

	@Transactional
	public boolean registerUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		return true;
	}

}
