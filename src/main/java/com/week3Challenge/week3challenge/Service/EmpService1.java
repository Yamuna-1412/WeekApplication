package com.week3Challenge.week3challenge.Service;

import java.util.List;
import java.util.Optional;

import com.week3Challenge.week3challenge.Entity.Employee;

public interface EmpService1 {

	

	List<Employee> listAll();

	void addEmployee(Employee emp);

	Employee findId(Integer id);



}
