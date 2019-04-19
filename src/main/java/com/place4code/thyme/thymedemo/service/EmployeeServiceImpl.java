package com.place4code.thyme.thymedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.place4code.thyme.thymedemo.dao.EmployeeRepo;
import com.place4code.thyme.thymedemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo employeeRepo;
	
	//Constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		//try to find:
		Optional<Employee> result = employeeRepo.findById(id);
		//found:
		if(result.isPresent()) return result.get();
		//not found:
		throw new RuntimeException("Employee with id: " + id + "does'nt exist");
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}

}
