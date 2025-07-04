package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/employee"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping({"/createEmployee"})  //http://localhost:9093/employee/createEmployee
    @Operation(summary = "Create employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee  saveEmployee = employeeService.create(employee);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{eId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long eId ,@RequestBody Employee employee){
       Employee updateById =  employeeService.updateEmployee(eId,employee);
       return new ResponseEntity<>(updateById,HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping({"/getById/{eId}"})
    public ResponseEntity<Employee> getById(@PathVariable long eId){
       Employee employeeByEid = employeeService.getById(eId);
       return new   ResponseEntity<>(employeeByEid, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{eId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long eId) {
        employeeService.deleteEmployee(eId);
        return new ResponseEntity<>("Employee Id with " + eId + " deleted successfully.", HttpStatus.OK);
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees,HttpStatus.FOUND);
    }

    @GetMapping("/by-department")
    public List<Employee> getEmployeesByDepartmentName(@RequestParam String departmentName) {
        return employeeService.getEmployeesByDepartmentName(departmentName);
    }
}
