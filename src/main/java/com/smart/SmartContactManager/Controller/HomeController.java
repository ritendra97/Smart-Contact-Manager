package com.smart.SmartContactManager.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.SmartContactManager.Dao.repository.UserRepository;
import com.smart.SmartContactManager.Models.User;
/*
  The model represents Java object carrying data. The view visualizes the data that the model contains.
  The controller manages the data flow into model object and updates the view whenever data changes; 
  it keeps view and model separate.
 */

@Controller
public class HomeController {

	@Autowired
	private UserRepository userrepository;
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "Home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String SignUp(Model model) {
		model.addAttribute("title", "SignUp - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping("/login")
	public String LogIn(Model model) {
		model.addAttribute("title", "Login - Smart Contact Manager");
		return "login";
	}
	
	// this handler for registering users
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model) {
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setImageUrl("default.png");
		user.setPassword(user.getPassword());
		User result = this.userrepository.save(user);
		model.addAttribute("user", result);
		return "signup";
	}
}
