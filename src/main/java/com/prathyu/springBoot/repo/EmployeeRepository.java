package com.prathyu.springBoot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prathyu.springBoot.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
