     package com.broadway.SpringJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework .web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.SpringJPA.model.Employee;
import com.broadway.SpringJPA.repository.EmployeeRepository;
import com.broadway.SpringJPA.service.IemployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private IemployeeService service;

	@GetMapping("/employee")
	public String addEmployee() {
		return "employeeForm";
	}

	@PostMapping("/employee")
	public String saveEmp(@ModelAttribute Employee emp) {
		// emprepo.save(emp);
		service.addEmployee(emp);
		return "employeeForm";
	}

	@GetMapping("/list")
	public String getAllEmployee(Model model) {
		// List<Employee> list = service.getEmpList();
		// model.addAttribute("empList", list);
		model.addAttribute("empList", service.getEmpList());
		return "listEmployee";
	}
  
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam Long id) {
		service.deleteEmployee(id);
		// emprepo.deleteById(id);
		return "redirect:list";
	}

	@GetMapping("/edit")
	public String editEmp(@RequestParam Long id, Model model) {
		// Employee emp = service.editEmployee(id);
		// model.addAttribute("emodel", emp);
		// model.addAttribute("emodel", emprepo.getById(id));

		model.addAttribute("emodel", service.editEmployee(id));
		return "editForm";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		service.updateEmployee(e);
		// emprepo.save(e);
		return "redirect:list";
	}
}
