package com.broadway.SpringJPA.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallery")
	public String gallery(Model model, HttpSession session) {

		session.getAttribute("session");
		File dir = new File("src/main/resources/static/images");
		String[] imgnames = dir.list();
		model.addAttribute("img", imgnames);

		return "galleryForm";
	}
}
