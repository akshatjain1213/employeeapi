package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//service contains business logic of program
// controller >- service >- repo

// EmployeeDto is return type

// client is sending data to it

// Employeedto is the one from where client sending data
// so it is user interface is dto and it send request to dto only

public interface EmployeeService {

    public static EmployeeDto createNewEmployee(EmployeeDto employeeDto) {

       return null;
    }


    public List<EmployeeDto>  getAllemployees();

    public EmployeeDto getEmployeeById(Long id);

    public  EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);

    public void deleteEmployeeById(Long id);
}
