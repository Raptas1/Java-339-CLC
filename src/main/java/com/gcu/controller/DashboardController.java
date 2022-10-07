package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	
	@Autowired
	UserModel userModel;

	@GetMapping("")
	public String displayDashboard(Model model) {
		model.addAttribute("username", userModel.credentials.getUsername());
		model.addAttribute("totalSales", userModel.getTotalNumSales());
		model.addAttribute("totalListings", userModel.getTotalNumListings());
		model.addAttribute("totalRevenue", userModel.getTotalRevenue());
		return "dashboard";
	}
	
	@GetMapping("/myListings")
	public String displayMyListings(Model model) {
		return "myListings";
	}
	
	@GetMapping("/listings")
	public String displayListings(Model model) {
		return "listings";
	}
}
