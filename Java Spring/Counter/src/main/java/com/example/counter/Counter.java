
package com.example.counter;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")

public class Counter {
	static  int count =0;
	@RequestMapping("")
	public String index(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count==null) {
			session.setAttribute("count", 1);
		}
		
		else {
			 count++;
		session.setAttribute("count", count);
	    }
		model.addAttribute("name", "reem");
		return "Index.jsp";
	}

	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/remove")
	public String reset(HttpSession session) {
		session.removeAttribute("count");
        return "redirect:/your_server/counter";
	}
}