package com.evolvfit.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.evolvfit.springboot.model.Employee;
import com.evolvfit.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomepage(Model model, String keyword, String id) {
		
		if(keyword!=null) {
			model.addAttribute("employees", employeeService.findByKeyword(keyword));
		}
		else 
		{
		     model.addAttribute("employees", employeeService.getAllEmployees());			
		}
		
		if(id!=null) {
			model.addAttribute("employees", employeeService.findById(id));
		}
		
		return "index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String newEmployeeForm(@Valid Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		System.out.println(employee + "new");
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newEmployee";
		}
		else {
			employeeService.saveEmployee(employee);
			return "redirect:/";
		}	
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
	
	
	
}
