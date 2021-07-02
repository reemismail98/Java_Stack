package com.test.BeltExam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.BeltExam.models.Course;
import com.test.BeltExam.models.User;
import com.test.BeltExam.services.ExamService;
import com.test.BeltExam.validator.UserValidator;

@Controller
public class ExamController {
	private final ExamService examService;
	private final UserValidator userValidator;

	public ExamController(ExamService examService, UserValidator userValidator) {
		this.examService = examService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "Registration.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "Registration.jsp";
		} else {
			User u = examService.registerUser(user);
			session.setAttribute("user_id", u.getId());
		}
		return "redirect:/courses";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthuntecation = examService.authenticateUser(email, password);
		if (isAuthuntecation) {
			User user1 = examService.findByEmail(email);
			session.setAttribute("user_id", user1.getId());
			return "redirect:/courses";
		} else {
			model.addAttribute("error", "Invalid,Please Try Again");
			return "Registration.jsp";
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

	@GetMapping("/courses")
	public String course(HttpSession session, Model model, @ModelAttribute("course") Course course) {
		Long userId = (Long) session.getAttribute("user_id");
		User u = examService.findUserById(userId);
		model.addAttribute("user", u);
		List<Course> courses = examService.allCourse();
		model.addAttribute("courses", courses);
		return "course.jsp";
	}

	@PostMapping(value = "/course/create")
	public String createEvent(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {

			return "addCourse.jsp";
		} else {
			examService.createCourse(course);
			return "redirect:/courses";
		}

	}


	@PostMapping("/courses/new")
	public String addCourse(HttpSession session, Model model, @ModelAttribute("course") Course course) {
		return "addCourse.jsp";
	}

	@RequestMapping("/courses/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		Course c = examService.findCourseById(id);
		model.addAttribute("course", c);
		return "courseEdit.jsp";
	}
	
	@PutMapping("/courses/{id}/update")
	public String updateCourse(Model model, @PathVariable("id") Long id,@Valid @ModelAttribute("course") Course course, BindingResult result,@PathVariable("id") Long course_id) {
		if (result.hasErrors()) {
			return "courseEdit.jsp";
		} else {
			
			examService.updateCourse(course);

			return "redirect:/courses";
		}
	}
	
	
	@GetMapping("/course/{course_id}")
	public String showEvent(Model model, @PathVariable("course_id") Long course_id, HttpSession session) {
		Course course= examService.findCourseById(course_id);
		 Long userId = (Long) session.getAttribute("user_id");
		 User user =examService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("course", course);
		return "addusetr.jsp";
	}

	@GetMapping(value = "/course/{course_id}/join")
	public String addAttendee(@PathVariable("course_id") Long course_id, HttpSession session,Model model) {
		User added = examService.findUserById((Long) session.getAttribute("user_id"));
		Course addedUser = examService.findCourseById(course_id);
		List<User> attendees = addedUser.getUsers();
		attendees.add(added);
		addedUser.setUsers(attendees);
		examService.updateUser(added);
		return "redirect:/courses";
	}
	
	
	
	@DeleteMapping("/courses/{course_id}/deleteCourse")
	public String deleteCource(@PathVariable("course_id") Long course_id, HttpSession session, Model model) {
		examService.deleteCourse(course_id);
		return "redirect:/courses";
	}
	@GetMapping("/course/{course_id}/delete")
	public String deleteUser(@PathVariable("course_id") Long course_id, HttpSession session, Model model) {
		Course course= examService.findCourseById(course_id);
		 Long userId = (Long) session.getAttribute("user_id");
		 User user =examService.findUserById(userId);
		 examService.deleteUserFromCourse(course, user);
		return "redirect:/course/{course_id}";
	}
}
