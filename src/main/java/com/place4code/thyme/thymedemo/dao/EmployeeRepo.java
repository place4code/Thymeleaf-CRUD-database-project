package com.place4code.thyme.thymedemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place4code.thyme.thymedemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
