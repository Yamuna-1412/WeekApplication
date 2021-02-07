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

	return emrp.findAll();
}

@Override
public Employee addEmployee(Employee emp) {
	emrp.save(emp);
	return emp;
}

@Override
public  Employee findId(Integer id ) {

  
		  
return emrp.findById(id).orElse(null);
}

@Override
public Optional<Employee> updateEmployee(Integer id, Employee e) {

	Optional<Employee> es1=emrp.findById(id);
	if(es1.isPresent())
	{ 
		Employee es=es1.get();
		es.setId(e.getId());
		es.setForename(e.getForename());
		es.setSurname(e.getSurname());
		es.setAge(e.getAge());
		e.setCompany(e.getCompany());
		e.setPostcode(e.getPostcode());
		emrp.save(es);
		
		
	}
	return es1;
	
	
}

@Override
public Optional<Employee> deleteEmployee(Integer id) throws NullPointerException {
	
	Optional<Employee> emps=emrp.findById(id);
	
	if(emps.isPresent())
	{
		Employee e=emps.get();
		emrp.delete(e);
	}
	return emps;
	
	
}




}
