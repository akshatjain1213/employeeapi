package com.example.employeeapi.mapper;


import com.example.employeeapi.dto.EmployeeDto;
import com.example.employeeapi.model.Employee;



// i am explaining first case:
//EmployeeDto IN FIRST LINE MEANS RETURN TYPE return to EmployeeDto
//maptoemployyedto is function name
// Employee is the entity from which we want to get data
//employee is used to get data

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getMobile_no()


        );
    }


    public static Employee maptoEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getMobile_no()
        );
    }
}

