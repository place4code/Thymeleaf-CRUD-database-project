package com.place4code.thyme.thymedemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.place4code.thyme.thymedemo.entity.Employee;


@Controller
@RequestMapping("employees")
public class EmployeeController {

	private List<Employee> employees;
	
	@PostConstruct
	private void fillList() {
		employees = new ArrayList<>();
		employees.add(new Employee(1, "Lucas", "Roma", "email"));
		employees.add(new Employee(2, "Claudia", "Roma", "emailClaudia"));
		employees.add(new Employee(3, "Khalessi", "Roma", "emailKhaleesi"));
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employees);
		
		return "list-employees";
		
	}
}
