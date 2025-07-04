package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeManageServiceApplication.class, args);
		System.out.println("Workig........");
	}

}
