package com.week3Challenge.week3challenge.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.week3Challenge.ExceptionHandle.EmployeeServiceException;
import com.week3Challenge.ExceptionHandle.RecordNotFoundException;
import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Repository.EmployeeRepository;
import com.week3Challenge.week3challenge.Service.EmpService1;

@RestController
@Validated
public class ControllerRest {

@Autowired
private EmployeeRepository emrp;

@Autowired 
private	EmpService1 empservice;
@GetMapping("/empser")
public List<Employee> display()
{
	return empservice.listAll();
}
@PutMapping("/emp/{id}")
public ResponseEntity<String> updateEmployee(@PathVariable(value = "id") Integer id, @Valid @RequestBody Employee e) throws MethodArgumentNotValidException
{
	Employee emp =emrp .findById(id).orElseThrow(() -> new RecordNotFoundException("No record found  on this id "+ id));
	emp.setForename(e.getForename());
	emp.setSurname(e.getSurname());
	emp.setAge(e.getAge());
	emp.setCompany(e.getCompany());
	emp.setPostcode(e.getPostcode());
	emrp.save(emp);
	return new ResponseEntity<String>("Record updated successfully", HttpStatus.OK);
	
}
@DeleteMapping("/emp1")
public ResponseEntity<?> deleteEmp(@PathParam(value = "id") Integer id)
{
	Employee emp =emrp .findById(id).orElseThrow(() -> new RecordNotFoundException("No record found  on this id "+ id));

    emrp.delete(emp);
    return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
	}
}














