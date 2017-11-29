package buis.dan.books;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookManager bookManager;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:/book_list";
	}
	
	@RequestMapping(value = "/book_list")
	public String listBooks(Model model) {
		logger.info("book_list");
		List<Book> books = bookManager.getAllBooks();
		logger.info(books.size()+" books");
		model.addAttribute("books", books);
		return "BookList";
		
	}
	
	@RequestMapping(value = "/book_edit/{id}")
	public String editBook(Model model, @PathVariable int id) {
		List<Category> categories = bookManager.getAllCategories();
		model.addAttribute("categories", categories);
		Book book = bookManager.get(id);
		model.addAttribute("book", book);
		return "BookEditForm";
	}
	
	@RequestMapping(value = "/book_update")
	public String updateBook(@ModelAttribute Book book) {
		Category category = bookManager.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookManager.update(book);
		return "redirect:/book_list";
	}
	
	@RequestMapping(value = "/book_input")
	public String inputBook(Model model){
		List<Category> categories = bookManager.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book",new Book());
		return "BookAddForm";
	}
	
	@RequestMapping(value = "/book_save")
	public String saveBook(@ModelAttribute Book book){
		Category category = bookManager.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookManager.save(book);
		return "redirect:/book_list";
	}
	
}
