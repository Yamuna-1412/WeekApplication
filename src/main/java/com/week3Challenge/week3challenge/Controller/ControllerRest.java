package com.week3Challenge.week3challenge.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.week3Challenge.week3challenge.Entity.Employee;

import com.week3Challenge.week3challenge.Service.EmpService1;

@RestController
@Validated
public class ControllerRest {


@Autowired 
private	EmpService1 empservice;

@GetMapping("/empser")
public List<Employee> display()
{
	return empservice.listAll();
}
@PutMapping("/emp/{id}")
public Employee updateEmployee(@PathVariable(value = "id") Integer id, @Valid @RequestBody Employee e)
{
empservice.updateEmployee(id,e);
	
	return e;
	}

@DeleteMapping("/emp1")
public ResponseEntity<String> deleteEmp(@PathParam(value = "id") Integer id) throws NullPointerException
{
	
	Optional<Employee> ee=empservice.deleteEmployee(id);
	if(ee.isPresent()) {
    return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
	}
	else {
		 return new ResponseEntity<String>("Record not deleted successfully", HttpStatus.NOT_FOUND);
	}
	}
}














