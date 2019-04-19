package com.place4code.thyme.thymedemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place4code.thyme.thymedemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
