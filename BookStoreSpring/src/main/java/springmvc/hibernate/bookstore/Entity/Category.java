package springmvc.hibernate.bookstore.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bs_category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Set<Book> bs_book;
	
	

	public Set<Book> getBs_book() {
		return bs_book;
	}
	public void setBs_book(Set<Book> bs_book) {
		this.bs_book = bs_book;
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
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
