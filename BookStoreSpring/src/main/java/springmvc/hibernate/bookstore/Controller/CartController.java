package springmvc.hibernate.bookstore.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.hibernate.bookstore.Entity.Cart;

@Controller
@RequestMapping("cartBook")
public class CartController {

	
	@GetMapping
	public String cartBook(ModelMap modelMap, HttpSession httpSession){
		
		List<Cart> carts  = (List<Cart>) httpSession.getAttribute("cart");
		modelMap.addAttribute("carts", carts);
		double totalMoney = 0;
		for(Cart cart: carts){
			totalMoney += cart.getPrice()*cart.getQuantity();
		}
		modelMap.addAttribute("totalMoney", totalMoney);
		
		return "CartManage";
		
	}
	
	
	
}
