package com.week3Challenge.week3challenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week3Challenge.week3challenge.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
