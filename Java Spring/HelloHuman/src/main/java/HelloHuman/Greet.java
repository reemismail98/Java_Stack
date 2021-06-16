package HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {
	@RequestMapping("")
	public String index(@RequestParam(value="name",required=false) String searchQuery) {
		if(searchQuery == null){
			return "<h3>Hello Human </h3>"+"<p>Welcome to SpringBoot</p>";
		}
		
		else if(searchQuery.length()>0) {
        return "<h3>Hello " + searchQuery +"</h3>"+"<p>Welcome to SpringBoot</p>";
    }
		
		return "<h3>Hello Human <'h3>"+"<p>Welcome to SpringBoot</p>";
	}
}
