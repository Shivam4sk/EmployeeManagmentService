package com.employee.repository;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByMobileNo(String mobileNo);

    boolean existsByEmailAndEIdNot(String email, Long eId);
    boolean existsByMobileNoAndEIdNot(String mobileNo, Long eId);
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findByDepartment(Department department);



}
