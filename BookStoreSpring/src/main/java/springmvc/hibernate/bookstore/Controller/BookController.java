package springmvc.hibernate.bookstore.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.hibernate.bookstore.Entity.Book;
import springmvc.hibernate.bookstore.Entity.Cart;
import springmvc.hibernate.bookstore.Service.BookService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String displayAllBook(ModelMap modelMap, @RequestParam int pageId, HttpSession httpSession){
		
		int count=3;
		int numberPage = pageId;
		if(pageId != 1){
			pageId = pageId-1;
			pageId = pageId*count+1;
		}
		List<Book> books = bookService.getBooksLimit(pageId, count);
		
		long sumRow = bookService.getRowCount();
		int maxPage = (int) (sumRow/count);
		if(maxPage %2 !=0){
			maxPage = maxPage +1;
		}
		
		if(httpSession.getAttribute("cart") != null){
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("quantity", carts.size());
			
		}
		
		modelMap.addAttribute("books", books);
		modelMap.addAttribute("maxPage", maxPage);
		modelMap.addAttribute("numberPage", numberPage);
		return "BookManage";
	}
	
	
	
	
	
	
	
	
}
