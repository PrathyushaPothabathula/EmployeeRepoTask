package com.prathyu.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.prathyu.springBoot.model.Employee;
import com.prathyu.springBoot.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private KafkaTemplate<String, String> kafka;

	@Value("${spring.kafka.topic.name}")
	private String topic;

	public EmployeeService(EmployeeRepository empRepo) {
		// TODO Auto-generated constructor stub
		this.empRepo = empRepo;
	}

	public List<Employee> listEmployees() {
		return empRepo.findAll();
	}

	public Optional<Employee> getEmployeeDetails(int id) {
		return empRepo.findById(id);

	}

	public String createEmployee(Employee emp) {
		empRepo.save(emp);
		return "Employee added succefully..";
	}

	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Employee deleted succefully..";
	}

	public String updateEmployee(Employee emp) {
		empRepo.save(emp);
		JSONObject payrollJSON= new JSONObject();
		payrollJSON.put("id", emp.getId());
		payrollJSON.put("ctc", emp.getCtc());
		kafka.send(topic,payrollJSON.toString());
		
		return "Employee updated successfully..";

	}
}
