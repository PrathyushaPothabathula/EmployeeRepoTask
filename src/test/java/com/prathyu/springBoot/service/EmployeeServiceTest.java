package com.prathyu.springBoot.service;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.prathyu.springBoot.model.Employee;
import com.prathyu.springBoot.repo.EmployeeRepository;

public class EmployeeServiceTest {
	EmployeeRepository empRepo;
	private EmployeeService service;

	@BeforeEach
	void setUp() {
		empRepo=mock(EmployeeRepository.class);
		this.service = new EmployeeService(empRepo);
	}
	
	@Test
	List<Employee> listEmployeesTest(){
		service.listEmployees();
		return verify(empRepo).findAll();
	}
	
	@Test
	Optional<Employee> getEmployeeDetailsTest(int id) {
		int empId=6;
		service.getEmployeeDetails(empId);
		return verify(empRepo).findById(empId);		
	}
	
	@Test
	void createEmployeeTest() {
		Employee emp=new Employee();
		emp.setId(5);
		emp.setAge(25);
		emp.setCtc(500000);
		emp.setFirstName("Anu");
		emp.setLastName("P");
		emp.setOrganisation("ABC");
		service.createEmployee(emp);
		verify(empRepo).save(emp);
	}
	
	void deleteEmployeeTest(int id) {
		int empId=3;
		service.deleteEmployee(empId);
		verify(empRepo).deleteById(empId);
	}
	
	void updateEmployeeTest(Employee emp) {
		emp.setId(6);
		emp.setAge(24);
		emp.setCtc(300000);
		emp.setFirstName("Anusha");
		emp.setLastName("Dk");
		emp.setOrganisation("ABC");
		service.updateEmployee(emp);
		verify(empRepo).save(emp);
	}
	
	
	

}
