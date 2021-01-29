package com.week3Challenge.week3challenge.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Repository.EmployeeRepository;

@Service
@Transactional
public class Service1 implements EmpService1 {
@Autowired
private EmployeeRepository emrp;

@Override
public List<Employee> listAll() {
	// TODO Auto-generated method stub
	return emrp.findAll();
}

@Override
public void addEmployee(Employee emp) {
	// TODO Auto-generated method stub
	emrp.save(emp);
}

@Override
public  Employee findId(Integer id ) {
	// TODO Auto-generated method stub
  Employee e=emrp.findById(id).orElse(null);
return e;
}




}
