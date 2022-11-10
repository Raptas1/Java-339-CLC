package com.gcu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ListingServiceInterface;
import com.gcu.business.MainBusinessService;
import com.gcu.data.ListingsDataService;
import com.gcu.model.ListingModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	UserModel userModel;
	
	@Autowired
	private ListingServiceInterface service;
	
	@Autowired
	private ListingsDataService listingsDataService;
	
	@Autowired
	MainBusinessService mainBusinessService;

	@GetMapping("")
	/**
	 * Displays dashboard
	 * @param model model
	 * @return dashboard view
	 */
	public String displayDashboard(Model model) {
		userModel = mainBusinessService.findUser(userModel.credentials.getUsername());
		String welcomeMessage = String.format("Welcome Back %s", userModel.getFirstName());
		model.addAttribute("username", welcomeMessage);
		model.addAttribute("totalSales", userModel.getTotalNumSales());
		model.addAttribute("totalListings", userModel.getTotalNumListings());
		model.addAttribute("totalRevenue", userModel.getTotalRevenue());
		return "dashboard";
	}
	
	@GetMapping("/myListings")
	/**
	 * Display mylisting view
	 * @param model model
	 * @return mylisting view
	 */
	public String displayMyListings(Model model) {
		model.addAttribute("listings", service.getListings());
		return "myListings";
	}
	
	@GetMapping("/listings")
	/**
	 * Display listing
	 * @param model model
	 * @return listing view
	 */
	public String displayListings(Model model) {
		model.addAttribute("listings", listingsDataService.findAll());
		return "listings";
	}
	
	@GetMapping("/create")
	/**
	 * display create view
	 * @param model model
	 * @return create view
	 */
	public String create(Model model)
	{
		model.addAttribute("listingModel", new ListingModel());
		return "create";
	}

	@PostMapping("/createSuccess")
	/**
	 * post method for create form 
	 * @param listingModel listingModel
	 * @param bindingResult bindingResult
	 * @param model model
	 * @return createSuccess view
	 */
	public String createSuccess(@Valid ListingModel listingModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
            return "create";
        }
	    System.out.println(service.findProcessor(listingModel));
		model.addAttribute("listings", service.createListing(listingModel));

		return "createSuccess";
	}
}