package com.employee.service;

import com.employee.entity.Department;
import com.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(Employee employee);
    Employee updateEmployee(Long eId,Employee employee);
    void deleteEmployee(Long eId);
    Employee  getById(Long eId);
    List<Employee> getAll();

    List<Employee> getEmployeesByDepartment(Department department);
    List<Employee> getEmployeesByDepartmentName(String departmentName);
}
