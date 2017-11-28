package buis.dan.books;

public class Book{
 private int id;
 private String isbn;
 private String title;
 private Category category;
 private String author;


 public Book() {
 }
 
 public Book(int id, String isbn, String title, Category category, String author) {
	 this.setId(id);
	 this.setIsbn(isbn);
	 this.setTitle(title);
	 this.setCategory(category);
	 this.setAuthor(author);
 }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}
}
