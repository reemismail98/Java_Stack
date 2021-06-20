package com.example.NinjaGoalGame;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGold {
	ArrayList<Object> list = new ArrayList<Object>();

	@RequestMapping("/")
	public String index(HttpSession session ,Model model) {
		if (session.getAttribute("gold")==null) {
		    session.setAttribute("gold",0);
		}

		return "NinjaGold.jsp";
	}
	
@RequestMapping(value="/procces_money",  method=RequestMethod.POST)
public String gold(HttpSession session ,Model model,@RequestParam(value="farm") String farm) {
    session.setAttribute("activity",list);
	Integer gooold=(Integer)session.getAttribute("gold");
	int rand=0;
    if(farm.equals("farm")) {
    	rand=(int) ((Math.random()*(20 - 10)) +10);
    	
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a"); 
    	 LocalDateTime now = LocalDateTime.now(); 
    	list.add("You are Earned "+ rand +" golds form the Farm ("+dtf.format(now)+")");
        session.setAttribute("activity", list);

    }
    else if(farm.equals("cave")) {
    	rand=(int) ((Math.random()*(10 - 5)) +5);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a"); 
   	 LocalDateTime now = LocalDateTime.now();
    	list.add("You are Earned "+ rand +" golds form the Cave ("+dtf.format(now)+")");
        session.setAttribute("activity", list);


    }
    else if(farm.equals("house")) {
    	rand=(int) ((Math.random()*(5 - 2)) +2);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a"); 
   	 LocalDateTime now = LocalDateTime.now();
    	list.add("You are Earned "+ rand +" golds form the House("+dtf.format(now)+")");
        session.setAttribute("activity", list);

    }
    else if(farm.equals("casino")) {
    	rand=(int) (Math.random()* (50 - (-50))) +(-50 );
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a"); 
   	 LocalDateTime now = LocalDateTime.now();
    	if(rand>0) {
    	list.add("You are Earned "+ rand +" golds form the Farm ("+dtf.format(now)+")");
        session.setAttribute("activity", list);
    	}
    	
    	else {
        	list.add("Entered a casino and lost "+rand+"golds form the Casino("+dtf.format(now)+")");
            session.setAttribute("activity", list);	
    	}
    }
    gooold+=rand;
    session.setAttribute("gold", gooold);

    
	return "redirect:/";

	}


}
