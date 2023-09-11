package com.broadway.SpringJPA.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String upload() {
		return "uploadForm";
	}

	@PostMapping("/upload")
	public String postUpload(@RequestParam ("file") MultipartFile file, Model model ) {
		
		if(!file.isEmpty()) {
			try {
				FileOutputStream file1 = new FileOutputStream("src/main/resources/static/images/"+ file.getOriginalFilename());
				file1.write(file.getBytes());
				file1.close();
				model.addAttribute("message", "Upload Successfully");
				return "uploadForm";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		model.addAttribute("message", "Upload Failed");
		return "uploadForm";
	}

}
