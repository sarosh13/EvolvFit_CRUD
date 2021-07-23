package com.evolvfit.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evolvfit.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	@Query(value="Select * from employees e where e.name like %:keyword%",nativeQuery=true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value="Select * from employees where id = :id",nativeQuery=true)
	List<Employee> findById(@Param("id") String id);
	
}
