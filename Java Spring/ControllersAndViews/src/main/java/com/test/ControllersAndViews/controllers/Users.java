package com.test.ControllersAndViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ControllersAndViews.models.User;
import com.test.ControllersAndViews.services.UserService;
import com.test.ControllersAndViews.validator.UserValidator;

@Controller
public class Users {
	private final UserService userService;
    private final UserValidator userValidator;

	public Users(UserService userService,UserValidator userValidator) {
		this.userService = userService;
		this.userValidator=userValidator;
	}

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "Registration.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "Registration.jsp";
		} else {
			User u=userService.registerUser(user);
			session.setAttribute("user_id", u.getId());
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpSession session) {
		boolean  isAuthuntecation = userService.authenticateUser(email, password);
		if (isAuthuntecation) {
			User user=userService.findByEmail(email);
			session.setAttribute("user_id", user.getId());
			return "redirect:/home";}
		else {
			model.addAttribute("error", "Invalid,Please Try Again");
			return "redirect:/registration";
		}
		

		// if the user is authenticated, save their user id in session
		// else, add error messages and return the login page
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userid=(Long) session.getAttribute("user_id");
		User user=userService.findUserById(userid);
		model.addAttribute("user",user);
		return "homepage.jsp";
		// get user from session, save them in the model and return the home page
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
		// invalidate session
		// redirect to login page
	}
}
