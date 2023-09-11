package com.broadway.SpringJPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller is used to handle request processing.
@Controller
public class IndexController {
	
	@GetMapping("/")
	public String indexPage() {
		return "login";
	}
}
