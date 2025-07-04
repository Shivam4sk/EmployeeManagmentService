package com.employee.serviceImpl;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        if(employeeRepository.findByEmail(employee.getEmail()).isPresent()){
            throw EmployeeException.emailAlreadyExists(employee.getEmail());
        }
        if (employeeRepository.findByMobileNo(employee.getMobileNo()).isPresent()){
            throw EmployeeException.mobileNumberAlreadyExists(employee.getMobileNo());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long eId, Employee employee) {
        Employee employeeExists = employeeRepository.findById(eId)
                .orElseThrow(() -> EmployeeException.getByIdNotFound(eId));


        if (employeeRepository.existsByEmailAndEIdNot(employee.getEmail(), eId)) {
            throw EmployeeException.emailAlreadyExists(employee.getEmail());
        }

        if (employeeRepository.existsByMobileNoAndEIdNot(employee.getMobileNo(), eId)) {
            throw EmployeeException.mobileNumberAlreadyExists(employee.getMobileNo());
        }

        employeeExists.setName(employee.getName());
        employeeExists.setEmail(employee.getEmail());
        employeeExists.setDepartment(employee.getDepartment());
        employeeExists.setRole(employee.getRole());
        employeeExists.setMobileNo(employee.getMobileNo());
        employeeExists.setSalary(employee.getSalary());

        return employeeRepository.save(employeeExists);
    }


    @Override
    public void deleteEmployee(Long eId) {
        if (employeeRepository.findById(eId).isEmpty()){
            throw EmployeeException.getByIdNotFound(eId);
        }
        employeeRepository.deleteById(eId);
    }

    @Override
    public Employee getById(Long eId) {
        return employeeRepository.findById(eId)
                .orElseThrow(()-> EmployeeException.getByIdNotFound(eId));
    }


    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }


}
