package com.reem.StringsAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class StringsAssignmentApplication {

	public static void main(String[] args) {
	
	SpringApplication.run(StringsAssignmentApplication.class, args);
}

@RequestMapping("/")
public String hello() { 
        return "Hello Client!How are you doing?";
}
@RequestMapping("/random")
public String springBoot(){
	return "Spring Boot is great! so easy to just respond with Strings";
}

}
