package com.employee.controller;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get employees by department name
    @GetMapping("/name/{name}/employees")
    public ResponseEntity<?> getEmployeesByDepartmentName(@PathVariable String name) {
        Optional<Department> departmentOpt = departmentRepository.findByNameWithEmployees(name);

        if (departmentOpt.isPresent()) {
            List<Employee> employees = departmentOpt.get().getEmployees();
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.status(404).body("No department found with name: " + name);
        }
    }
}
