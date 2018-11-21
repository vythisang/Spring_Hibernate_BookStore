package springmvc.hibernate.bookstore.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import springmvc.hibernate.bookstore.Entity.Book;
import springmvc.hibernate.bookstore.Entity.Cart;
import springmvc.hibernate.bookstore.Entity.User;
import springmvc.hibernate.bookstore.Service.UserService;

@Controller
@SessionAttributes({"user","cart"})
@RequestMapping("api")
public class ApiController {

	@Autowired
	private UserService userService;

	@GetMapping("/checkLogin/")
	@ResponseBody
	public String checkLogin(ModelMap modelMap, @RequestParam String name, @RequestParam String password) {

		User user = userService.isUserExists(name, password);
		if (user != null) {
			modelMap.addAttribute("user", user);
			return "true";
		}

		return "false";
	}

	
	
	@GetMapping("/checkRegister/")
	@ResponseBody
	public String checkRegister(ModelMap modelMap,@RequestParam String name,@RequestParam String password,@RequestParam String email,@RequestParam String dob){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date convertDob;
		try {
			convertDob = sdf.parse(dob);
			User user = new User(email, password, name, convertDob);
			if(userService.isUserExists(name, password)!= null){
				return "false";
			}else{
				userService.registerUser(user);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return "true";
	}
	
	
	
	@PostMapping("/addCart/")
	@ResponseBody
	public String addCart(ModelMap modelMap,HttpSession httpSession,@RequestParam int id,@RequestParam String name, @RequestParam String price, @RequestParam String quantity,@RequestParam String image){
		Cart cart = new Cart();
		cart.setName(name);
		cart.setPrice(Double.parseDouble(price));
		cart.setQuantity(Integer.parseInt(quantity));
		cart.setImage(image);
		cart.setId(id);
		
		if(httpSession.getAttribute("cart")==null){
			List<Cart> carts = new ArrayList<Cart>();
			carts.add(cart);
			httpSession.setAttribute("cart", carts);
			return ""+carts.size();
		}else{
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = isBookExistsInCart(httpSession,id);
			if(index==-1){
				carts.add(cart);
			}else{
				carts.get(index).setQuantity(Integer.parseInt(quantity));
			}
			return ""+carts.size();
		}
		
	}
	
	
	private int isBookExistsInCart(HttpSession httpSession,int id){
		List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
		for(int i=0;i<carts.size();i++){
			if(carts.get(i).getId() == id ){
				return i;
			}
		}
		return -1;
	}
	
	
}
