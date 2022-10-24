package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityService;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserModel userModel = new UserModel();
	
	@Autowired
	SecurityService securityService;

	@GetMapping("")
	public String displayRegister(Model model) {
		model.addAttribute("userModel", userModel);
		return "register";
	}
	
	
	@PostMapping("")
	public String registered(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return ("/register");
		}
		
		if(!securityService.verify(userModel, bindingResult)) {
			return ("/register");
		}
		
		System.out.println("Username: " + userModel.credentials.getUsername() + " Password: " + userModel.credentials.getPassword());
		this.userModel.setFirstName(userModel.getFirstName());
		this.userModel.setLastName(userModel.getLastName());
		this.userModel.credentials.setUsername(userModel.credentials.getUsername());
		this.userModel.credentials.setPassword(userModel.credentials.getPassword());
		this.userModel.setEmail(userModel.getEmail());
		return ("redirect:/dashboard");
	}
	
}

