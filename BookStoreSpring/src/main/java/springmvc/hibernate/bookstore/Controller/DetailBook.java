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

@Controller()
@RequestMapping("detaiBook")
public class DetailBook {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String detailBook(ModelMap modelMap, @RequestParam int id, HttpSession httpSession){
		
		if(httpSession.getAttribute("cart") != null){
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("quantity", carts.size());
		}
		
		Book book = bookService.getBookById(id);
		modelMap.addAttribute("book", book);
		
		return "DetailBook";
	}
	
}
