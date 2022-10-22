package com.gcu.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.ListingModel;
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
		List<ListingModel> listings = new ArrayList<ListingModel>();
		model.addAttribute("myListings", listings);
		return "myListings";
	}

	@GetMapping("/listings")
	public String displayListings(Model model) {
		return "listings";
	}

	@GetMapping("/create")
	public String create(Model model)
	{
		model.addAttribute("listingModel", new ListingModel());
		return "create";
	}

	@PostMapping("/createSuccess")
	public String createSuccess(@Valid ListingModel listingModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
            return "create";
        }
	    
		model.addAttribute("listings", listingModel.generateListings(listingModel));

		return "myListings";
	}

}
