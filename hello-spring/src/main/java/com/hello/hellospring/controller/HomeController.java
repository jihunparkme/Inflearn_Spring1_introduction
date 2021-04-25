package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/*
	 * Controller에서 매핑되는 URL이은 welcome page보다 높은 우선순위르 갖음.
	 */
	@GetMapping("/")
	public String home() {
		return "home";
	}
}