package com.example.helloBoot.Lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class LessonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonsApplication.class, args);
	}

}

//@RestController
//class HellController {
//
//	@GetMapping("/")
//	public String hell()
//	{
//		return "HELL YOU!";
//	}
//	
//}
