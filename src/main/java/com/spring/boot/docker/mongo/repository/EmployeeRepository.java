package com.spring.boot.docker.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.boot.docker.mongo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> 
{
}
