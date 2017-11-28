package buis.dan.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class BookManager {

	private List<Category> categories;
	private List<Book> books;
	
	public BookManager() {
		categories = new ArrayList<Category>();
		Category category1 = new Category(1,"Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3, "Health");
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		books = new ArrayList<Book>();
		books.add(new Book(1, "978098083923", "JSP : Tutorials", category1, "Frank Allen"));
		books.add(new Book(2, "458200983001", "Hawaii travel guide", category2, "Moana"));	
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public Book save(Book book) {
		book.setId(books.size()+1);
		books.add(book);
		return book;
	}

	public List<Category> getAllCategories() {
		return categories;
	}

	public Book get(int id) {
		for(Book book:books) {
			if(id==book.getId()) {
				return book;
			}
		}
		return null;
	}

	public Category getCategory(int id) {
		for(Category category:categories) {
			if(id==category.getId()) {
				return category;
			}
		}
		return null;
	}

	public Book update(Book updatedBook) {
		for (int i=0; i<books.size(); i++) {
			Book oldBook = books.get(i);
			if(oldBook.getId()==updatedBook.getId()) {
				books.set(i, updatedBook);
				return updatedBook;
			}
		}
		return updatedBook;	
	}
	
	public int getNextID() {
		return books.size()+1;
	}
}
