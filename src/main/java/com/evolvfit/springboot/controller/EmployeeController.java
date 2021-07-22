package com.evolvfit.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.evolvfit.springboot.model.Employee;
import com.evolvfit.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		
		model.addAttribute("employeeList", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String newEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") @RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployeeForm(@PathVariable(value="id") int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@GetMapping("/deleteEmployeeForm/{id}")
	public String deleteEmployeeForm(@PathVariable(value="id") int id, Model model) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm(Model model) {
		System.out.println("1");
		Employee employee = new Employee();
		model.addAttribute("employees", employee);
		System.out.println("2");
		return "getEmployee";
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public String getEmployeeById(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("employees", employeeService.getEmployeeById(id));
		return "getEmployeeById";
	}
	
}
