package com.broadway.SpringJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadway.SpringJPA.model.User;
import com.broadway.SpringJPA.repository.UserRepository;

@Controller
public class SignupController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("signupindex")
	public String signupIndex() {
		return "signup";
	}

	@PostMapping("signup")
	public String setUser(@ModelAttribute User user, Model model) {

		if (user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()
				|| user.getPhone().isBlank()) {
			model.addAttribute("message", "fill the all fields !!!");
            return "signup";
		}
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepo.save(user);
		model.addAttribute("name", user.getName());
		model.addAttribute("message1"
				+ "", "now u can login with name and password ");
		return "login";
	}
}
