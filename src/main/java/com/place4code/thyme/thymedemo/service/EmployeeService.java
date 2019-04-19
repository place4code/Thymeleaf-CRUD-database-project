package com.place4code.thyme.thymedemo.service;

import java.util.List;

import com.place4code.thyme.thymedemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);

}
