package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("")
	public String displayLogin(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public RedirectView doLogin(UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("Username: %s and Password %s", userModel.getUsername(), userModel.getPassword()));
		return new RedirectView("/dashboard");
	}
}
