package Test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String coding() { 
	        return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String pyDojo(){
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String javaSpring() {
		return "Java/Spring is better!";
	}
}
