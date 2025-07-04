package com.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="empDetails")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eId;

    private String name;

    @Column(unique = true,nullable = false)
    @NotBlank
    @Email(message = "Invalid email format")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


    private String role;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid number must be 10 digit(must be 10 digits, start with 6-9)")
    private String mobileNo;

    private double salary;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotBlank @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public @NotNull @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid number must be 10 digit(must be 10 digits, start with 6-9)") String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(@NotNull @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid number must be 10 digit(must be 10 digits, start with 6-9)") String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
