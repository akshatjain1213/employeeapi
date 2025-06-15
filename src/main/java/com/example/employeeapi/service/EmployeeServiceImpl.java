package com.example.employeeapi.service;


import com.example.employeeapi.dto.EmployeeDto;
import com.example.employeeapi.exception.EmployeeResearchNotFoundException;
import com.example.employeeapi.mapper.EmployeeMapper;
import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//createNewEmployee() → converts DTO to entity, saves it, and converts back to DTO
//EmployeeMapper.maptoEmployee() → converts DTO to entity
//
//employeeRepo.save() → saves to the DB using Spring Data JPA
//
//EmployeeMapper.maptoEmployeeDto() → converts saved entity back to DTO for the response



@Service
@AllArgsConstructor


public  class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo employeeRepo;

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto){

        Employee newEmployee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(newEmployee);
        return  EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }




    public List<EmployeeDto> getAllemployees(){
        List<Employee> allEmployees = employeeRepo.findAll();
        return  allEmployees.stream().map(e -> EmployeeMapper.maptoEmployeeDto(e)).collect(Collectors.toList());
    }


       public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeResearchNotFoundException("Employee id requested does not exist"));
        return EmployeeMapper.maptoEmployeeDto(employee);
       }


       public  EmployeeDto updateEmployeeById(Long id , EmployeeDto employeeDto){
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeResearchNotFoundException("Employee id requested does not exist"));
           employee.setName(employeeDto.getName());
           employee.setEmail(employeeDto.getEmail());
           employee.setMobile_no(employeeDto.getMobile_no());
           employeeRepo.save(employee);
           return EmployeeMapper.maptoEmployeeDto(employee);

       }

       public void deleteEmployeeById(Long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeResearchNotFoundException("NO ID "));

        employeeRepo.deleteById(id);
       }
}
