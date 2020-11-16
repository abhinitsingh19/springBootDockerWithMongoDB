package com.spring.boot.docker.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.docker.mongo.model.Employee;
import com.spring.boot.docker.mongo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository empRepository;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		empRepository.save(emp);
		return "employee added successfully::"+emp.getId();
		
	}
	
	@GetMapping("/findAllEmployees")
	public List<Employee> getEmployees() {
		return empRepository.findAll();
	}

	@GetMapping("/findEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable String id) {
		return empRepository.findById(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		empRepository.deleteById(id);
		return "Deleted Employee Successfully::"+id;
	}
	
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@RequestBody Employee emp,@PathVariable String id) {
		System.out.println("Input emp "+ emp);
		Optional<Employee> findById = empRepository.findById(id);
		System.out.println("Persisted emp "+ findById.get());
		findById.get().setName(emp.getName());
		return "Employee updated Successfully::"+id;
	}


}
