package com.employee.exception;

import com.employee.entity.Employee;

public class EmployeeException extends RuntimeException{

    public EmployeeException(String messege) {
        super(messege);
    }
    public static EmployeeException emailAlreadyExists(String email) {
        return new EmployeeException("Email already exists: " + email);
    }

    public static EmployeeException mobileNumberAlreadyExists(String mobileNo){
        return new EmployeeException("Mobile number already exists: "+mobileNo);
    }

    public static EmployeeException getByIdNotFound(Long eId){
        return  new EmployeeException("Id not found: "+eId);
    }
}
