package springmvc.hibernate.bookstore.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.hibernate.bookstore.Entity.Cart;

@Controller
@RequestMapping("/")
public class HomeController {

	
	@GetMapping
	public String defaultPage(HttpSession httpSession, ModelMap modelMap){
		
		if(httpSession.getAttribute("cart") != null){
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("quantity", carts.size());
		}
		
		return "Home";
	}
}
