package com.example.helloBoot.Lessons.Controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
	
	
	@Value("${welcome.message}")
	private String welcome_message;
	
	@GetMapping("/yes")
	public String hello()
	{
		return welcome_message;
	}
	
	@GetMapping("/todo")
	public String ye()
	{
		return "I AM GOD!";
	}

}
