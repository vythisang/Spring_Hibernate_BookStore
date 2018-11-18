package springmvc.hibernate.bookstore.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bs_author_book")
public class AuthorBook {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private Author bs_author;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Book bs_book;


	
	private double revenue_share;
	
	
	
	public double getRevenue_share() {
		return revenue_share;
	}


	public void setRevenue_share(double revenue_share) {
		this.revenue_share = revenue_share;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Author getBs_author() {
		return bs_author;
	}


	public void setBs_author(Author bs_author) {
		this.bs_author = bs_author;
	}


	public Book getBs_book() {
		return bs_book;
	}


	public void setBs_book(Book bs_book) {
		this.bs_book = bs_book;
	}


	
	
}
