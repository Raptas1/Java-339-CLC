package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("")
	/**
	 * Displays main
	 * @return
	 */
	public String displayMain() {
		return "main";
	}
	
	@GetMapping("/about")
	/**
	 * Displays about
	 * @return
	 */
	public String displayAbout() {
		return "about";
	}
	
	@GetMapping("/listing")
	/**
	 * Displays public listings
	 * @return
	 */
	public String displayPublicListings() {
		return "publicListings";
	}
}
