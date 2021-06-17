package com.example.TheCode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCode {
@RequestMapping("")
public String index(HttpSession session) {
	session.setAttribute("name", "bushido");
	return "index.jsp";
}

@RequestMapping(value="/code" , method=RequestMethod.POST)
public String code(@RequestParam(value="name") String name,HttpSession session,RedirectAttributes redirectAttributes) {
	if(session.getAttribute("name").equals(name)) {
		return "code.jsp";
	}
	else {
		redirectAttributes.addFlashAttribute("error", "You must train Harder");
		return "redirect:/";
	}
}
}
