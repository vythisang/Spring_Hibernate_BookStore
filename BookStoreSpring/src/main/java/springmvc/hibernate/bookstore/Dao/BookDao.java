package springmvc.hibernate.bookstore.Dao;

import java.util.List;

import springmvc.hibernate.bookstore.Entity.Book;

public interface BookDao {

	List<Book> getAllBook();
	
	List<Book> getBooksLimit(int start, int count);
	
	Long getRowCount();
}
