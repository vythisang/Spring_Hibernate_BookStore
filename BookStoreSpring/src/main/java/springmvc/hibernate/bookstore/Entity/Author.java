package springmvc.hibernate.bookstore.Entity;

import java.util.Date;
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
@Table(name="bs_author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date dob;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private Set<AuthorBook> bs_author_book;
	
	
	
	
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Author(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
