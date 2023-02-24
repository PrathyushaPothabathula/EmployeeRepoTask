package com.prathyu.springBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prathyu.springBoot.model.Employee;
import com.prathyu.springBoot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@RequestMapping("/getemployees")
	public List<Employee> listEmployees() {
		return empService.listEmployees();
	}

	@RequestMapping("/getemployees/{id}")
	public Optional<Employee> getEmployeeDetails(@PathVariable int id) {
		return empService.getEmployeeDetails(id);

	}

	@PostMapping("/addemployee")
	public String createEmployee(@RequestBody Employee emp) {
		return empService.createEmployee(emp);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empService.deleteEmployee(id);

	}

	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp) {

		return empService.updateEmployee(emp);

	}

}
