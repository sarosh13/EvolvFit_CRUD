package com.evolvfit.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evolvfit.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
