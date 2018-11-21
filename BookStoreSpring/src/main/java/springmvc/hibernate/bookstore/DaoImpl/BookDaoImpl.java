package springmvc.hibernate.bookstore.DaoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.hibernate.bookstore.Dao.BookDao;
import springmvc.hibernate.bookstore.Entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Book> getBooksLimit(int start, int count) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Book ";
		Query query = session.createQuery(sql, Book.class);
		query.setFirstResult(start - 1);
		query.setMaxResults(count);
		List<Book> books = query.list();

		return books;
	}

	@Transactional
	public Long getRowCount() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select count(*) from Book";
		Query query = session.createQuery(sql);
		long count = (Long) query.uniqueResult();
		return count;
	}

	@Transactional
	public Book getBookById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Book where id= :id";
		Query query = session.createQuery(sql, Book.class);
		query.setParameter("id", id);
		Book book = (Book) query.getSingleResult();

		return book;
	}

}
