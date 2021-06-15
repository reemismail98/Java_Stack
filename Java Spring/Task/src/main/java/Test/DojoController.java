package Test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DojoController {
	@RequestMapping("/{text}")
	public String index(@PathVariable("text") String str) {
		if (str.equals("dojo")) {
			return "The " + str + " is awesome! ";
		} 
		
		else if (str.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}

		else if (str.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
       return  "";
	}
}
