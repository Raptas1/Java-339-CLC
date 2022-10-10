package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("")
	public String displayLogin(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
	@PostMapping("")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasFieldErrors("credentials.username") && bindingResult.hasFieldErrors("credentials.password")) {
			return "/login";
		}
		
		return ("redirect:/dashboard");
	}
}
