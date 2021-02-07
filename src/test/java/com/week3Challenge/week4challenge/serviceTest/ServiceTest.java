package com.week3Challenge.week3challenge.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Repository.EmployeeRepository;
import com.week3Challenge.week3challenge.Service.EmpService1;
@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceTest {

	@Autowired 
	private EmpService1 empSer;
	@MockBean
	private EmployeeRepository emprepo;
	@Test
	public void  createEmployeeTest()
	{
		Employee e=new Employee();
		e.setForename("Ram");
		e.setForename("Mal");
		e.setAge(22);
		e.setCompany("TCS");
		e.setPostcode("12121");
		Mockito.when(emprepo.save(e)).thenReturn(e);
		assertThat(empSer.addEmployee(e)).isEqualTo(e);
	}
	@Test
	public void  getEmployeeListTest()
	{
		Employee e=new Employee();
		e.setForename("Ram");
		e.setForename("Mal");
		e.setAge(22);
		e.setCompany("TCS");
		e.setPostcode("12121");
		Employee e2=new Employee();
		e2.setForename("Nikki");
		e2.setForename("Mal");
		e2.setAge(22);
		e2.setCompany("TCS");
		e2.setPostcode("12121");
		List<Employee> elist=new ArrayList<>();
		elist.add(e);
		elist.add(e2);
		
		Mockito.when(emprepo.findAll()).thenReturn(elist);
		assertThat(empSer.listAll()).isEqualTo(elist);
		
		
	}
	
}
