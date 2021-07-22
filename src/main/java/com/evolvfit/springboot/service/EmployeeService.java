package com.evolvfit.springboot.service;

import java.util.List;

import com.evolvfit.springboot.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);
}
