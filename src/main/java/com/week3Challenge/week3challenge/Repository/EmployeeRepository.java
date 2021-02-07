package com.week3Challenge.week3challenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.week3Challenge.week3challenge.Entity.Employee;
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
  
}
