package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserModel userModel = new UserModel();

	@GetMapping("")
	public String displayRegister(Model model) {
		model.addAttribute("userModel", userModel);
		return "register";
	}
	
	
	@PostMapping("/registered")
	public RedirectView registered(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		this.userModel.setFirstName(userModel.getFirstName());
		this.userModel.setLastName(userModel.getLastName());
		this.userModel.setUsername(userModel.getUsername());
		this.userModel.setPassword(userModel.getPassword());
		this.userModel.setEmail(userModel.getEmail());
		return new RedirectView("/dashboard");
	}
}

