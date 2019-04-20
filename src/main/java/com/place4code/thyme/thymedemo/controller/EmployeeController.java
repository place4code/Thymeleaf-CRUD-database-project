package com.place4code.thyme.thymedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.place4code.thyme.thymedemo.entity.Employee;
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
		return "employees/list";
		
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		
		//add attribute
		model.addAttribute("employee", new Employee());
		
		//return form view
		return "employees/save";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//save employee
		employeeService.save(employee);
		//redirect to list
		return "redirect:/employees/list";
		
	}
	
	
}
