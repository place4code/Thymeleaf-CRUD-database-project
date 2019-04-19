package com.place4code.thyme.thymedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.place4code.thyme.thymedemo.service.EmployeeService;


@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	// !!! Constructor injection - @Autowired is optional
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//employees from database -> findAll()
		model.addAttribute("employees", employeeService.findAll());
		
		//return view with list of employees
		return "list-employees";
		
	}
}
