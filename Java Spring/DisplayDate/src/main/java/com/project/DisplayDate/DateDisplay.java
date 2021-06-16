package com.project.DisplayDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateDisplay {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "DateTime.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEE,' the ' dd ' of ' MMMM, yyyy");
		model.addAttribute("date", df.format(date));
		return "DatePage.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		model.addAttribute("time", (localTime.format(dateTimeFormatter)));
		return "TimePage.jsp";
	}
}