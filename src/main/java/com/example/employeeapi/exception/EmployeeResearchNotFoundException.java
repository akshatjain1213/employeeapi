package com.example.employeeapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeResearchNotFoundException extends RuntimeException{

    public EmployeeResearchNotFoundException(String message){
        super(message);
    }
}
