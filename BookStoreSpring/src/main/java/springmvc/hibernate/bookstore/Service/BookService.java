package springmvc.hibernate.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.hibernate.bookstore.Dao.BookDao;
import springmvc.hibernate.bookstore.Entity.Book;

@Service
public class BookService implements BookDao{

	@Autowired
	private BookDao bookDao;

	public List<Book> getAllBook() {
		return bookDao.getAllBook();
	}

	public List<Book> getBooksLimit(int start, int count) {
		return bookDao.getBooksLimit(start, count);
	}

	public Long getRowCount() {
		return bookDao.getRowCount();
	}

	
	
	
	



}
