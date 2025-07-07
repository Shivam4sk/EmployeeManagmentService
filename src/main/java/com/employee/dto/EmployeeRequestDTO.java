package com.employee.dto;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;
    private String email;
    private String mobileNo;
    private String role;
    private double salary;
    private Long departmentId;
}
