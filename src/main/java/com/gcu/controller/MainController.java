package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("")
	public String displayMain() {
		return "main";
	}
	
	@GetMapping("/about")
	public String displayAbout() {
		return "about";
	}
	
	@GetMapping("/listing")
	public String displayPublicListings() {
		return "publicListings";
	}
}
