package com.example.employeeapi.repository;


import com.example.employeeapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository connects with database
// this jpa is used for auto crud operations
// this Employee is written because of entity
// long is used beacuse data type of primary key in entity

public interface EmployeeRepo extends JpaRepository<Employee,Long> {


 }
