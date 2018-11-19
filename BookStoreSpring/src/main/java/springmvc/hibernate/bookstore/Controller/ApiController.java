package springmvc.hibernate.bookstore.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import springmvc.hibernate.bookstore.Entity.User;
import springmvc.hibernate.bookstore.Service.UserService;

@Controller
@SessionAttributes("user")
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
	
	
	
	
	
}
