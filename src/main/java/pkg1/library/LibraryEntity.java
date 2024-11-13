package pkg1.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class LibraryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bookName;
	private int publishedYear;
	private String publisher;
	private String author;
	
	public LibraryEntity() {
		super();
	}
	public LibraryEntity(int id, String bookName, int publicedYear, String publisher, String author) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.publishedYear = publicedYear;
		this.publisher = publisher;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPublicedYear() {
		return publishedYear;
	}
	public void setPublicedYear(int publicedYear) {
		this.publishedYear = publicedYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
