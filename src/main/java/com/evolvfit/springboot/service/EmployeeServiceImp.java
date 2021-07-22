package com.evolvfit.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvfit.springboot.model.Employee;
import com.evolvfit.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		this.employeeRepo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> opt = employeeRepo.findById(id);
		Employee employee = null;
		if(opt.isPresent()) {
			employee = opt.get();
		}
		else {
			throw new RuntimeException("Sorry, the employee with id not found");
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepo.deleteById(id);
		
	}
	
	
	

	
}
