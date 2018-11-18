package springmvc.hibernate.bookstore.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bs_book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int sold_number;
	private double price;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category bs_category;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Set<AuthorBook> bs_author_book;
	
	
	public Category getBs_category() {
		return bs_category;
	}
	public void setBs_category(Category bs_category) {
		this.bs_category = bs_category;
	}
	public Set<AuthorBook> getBs_author_book() {
		return bs_author_book;
	}
	public void setBs_author_book(Set<AuthorBook> bs_author_book) {
		this.bs_author_book = bs_author_book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSold_number() {
		return sold_number;
	}
	public void setSold_number(int sold_number) {
		this.sold_number = sold_number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(int id, String name, int sold_number, double price) {
		super();
		this.id = id;
		this.name = name;
		this.sold_number = sold_number;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
