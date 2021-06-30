package com.test.EventsBeltReviewer.controller;

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

import com.test.EventsBeltReviewer.models.Event;
import com.test.EventsBeltReviewer.models.Message;
import com.test.EventsBeltReviewer.models.User;
import com.test.EventsBeltReviewer.services.EventService;
import com.test.EventsBeltReviewer.validator.UserValidator;

@Controller
public class EventController {
	private final EventService eventService;
	private final UserValidator userValidator;
	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
			"IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
			"NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
			"WY" };

	public EventController(EventService eventService, UserValidator userValidator) {
		this.eventService = eventService;
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
			User u = eventService.registerUser(user);
			session.setAttribute("user_id", u.getId());
		}
		return "redirect:/events";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthuntecation = eventService.authenticateUser(email, password);
		if (isAuthuntecation) {
			User user1 = eventService.findByEmail(email);
			session.setAttribute("user_id", user1.getId());
			return "redirect:/events";
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

	@GetMapping("/events")
	public String events(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long userId = (Long) session.getAttribute("user_id");
		User u = eventService.findUserById(userId);
		model.addAttribute("user", u);
		String state = u.getState();
		List<Event> eventsIn = eventService.eventsInState(state);
		model.addAttribute("eventsIn", eventsIn);
		List<Event> eventsOut = eventService.eventsOutOfState(state);
		model.addAttribute("eventsOut", eventsOut);
		model.addAttribute("states", states);

		return "events.jsp";
	}

	@PostMapping(value = "/events/create")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			User u = eventService.findUserById(userId);
			model.addAttribute("user", u);
			String state = u.getState();
			List<Event> eventsIn = eventService.eventsInState(state);
			model.addAttribute("eventsIn", eventsIn);
			List<Event> eventsOut = eventService.eventsOutOfState(state);
			model.addAttribute("eventsOut", eventsOut);
			model.addAttribute("states", states);

			return "events.jsp";}
		else {
		eventService.createEvent(event);
		return "redirect:/events";}

	}

	@GetMapping(value = "/events/{event_id}/join")
	public String addAttendee(@PathVariable("event_id") Long event_id, HttpSession session) {
		User attendee = eventService.findUserById((Long) session.getAttribute("user_id"));
		Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getUsers();
		attendees.add(attendee);
		attending_event.setUsers(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
	}

	@GetMapping(value = "/events/{event_id}/cancel")
	public String removeAttendee(@PathVariable("event_id") Long event_id, HttpSession session) {
		User attendee = eventService.findUserById((Long) session.getAttribute("user_id"));
		Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getUsers();
		attendees.remove(attendee);
		attending_event.setUsers(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
	}

	@GetMapping("/events/{event_id}/delete")
	public String deleteEvent(@PathVariable("event_id") Long event_id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("session_id", userId);
		eventService.deleteEvent(event_id);
		return "redirect:/events";
	}

	@RequestMapping("/events/{event_id}/edit")
	public String editEvent(@PathVariable("event_id") Long event_id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		Event event = eventService.findEventById(event_id);
		model.addAttribute("event", event);
		model.addAttribute("states", states);
		return "eventsEdit.jsp";
	}

	@PutMapping("/events/{id}/update")
	public String updateEvent(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("states", states);
			return "eventsEdit.jsp";
		} else {
			this.eventService.updateEvent(event);
			return "redirect:/events/" + event.getId();
		}
	}

	@GetMapping("/events/{event_id}")
	public String showEvent(@ModelAttribute("message") Message message,Model model, @PathVariable("event_id") Long event_id, HttpSession session) {
		Event event = eventService.findEventById(event_id);
		 Long userId = (Long) session.getAttribute("user_id");
		 User user =eventService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		return "eventsId.jsp";
	}
	
	@PostMapping("/events/{event_id}/comment")
	public String addMessage(@Valid @ModelAttribute("message") Message message, BindingResult result,Model model,@PathVariable("event_id") Long event_id,HttpSession session) {
		if (result.hasErrors()) {
			Event event = eventService.findEventById(event_id);
			 Long userId = (Long) session.getAttribute("user_id");
			 User user =eventService.findUserById(userId);
			model.addAttribute("user", user);
			model.addAttribute("event", event);
			return "eventsId.jsp";}
		else {
        
		 Long userId = (Long) session.getAttribute("user_id");
		 User user =eventService.findUserById(userId);
			model.addAttribute("user", user);
			eventService.createMessage(message);
		return "redirect:/events/" + event_id;}
	}
}
