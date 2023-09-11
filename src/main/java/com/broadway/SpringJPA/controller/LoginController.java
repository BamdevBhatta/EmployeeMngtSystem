package com.broadway.SpringJPA.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.broadway.SpringJPA.model.User;
import com.broadway.SpringJPA.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository urepo;
@GetMapping("/login")
	public String getLogin() {
return "login";
	}

	@PostMapping("/postlogin")
	public String postLogin(@ModelAttribute User use, Model md, HttpSession session) {
		
		use.setPassword(DigestUtils.md5DigestAsHex(use.getPassword().getBytes()));
		User user =   urepo.findByNameAndPassword(use.getName(), use.getPassword());
		
		if (user != null) {
			session.setAttribute("session", user);
			session.setMaxInactiveInterval(300);
			md.addAttribute("name", use.getName());
			return "home";
		}
		md.addAttribute("message", "User not found!!");
		return "login";
	}
}
