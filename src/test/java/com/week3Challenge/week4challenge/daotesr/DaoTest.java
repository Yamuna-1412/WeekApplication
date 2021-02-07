package com.week3Challenge.week3challenge.daotesr;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Repository.EmployeeRepository;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
class DaoTest {

	@Autowired
	private EmployeeRepository emprp;
	@Test
	public void saveTest()
	{
		Employee e=new Employee();
		e.setForename("Ram");
		e.setSurname("Mal");
		e.setAge(22);
		e.setCompany("TCS");
		e.setPostcode("12121");
		Employee esave=emprp.save(e);
		assertNotNull(esave);
	}  
	@Test
	public void testListProducts() {
	    List<Employee> emp = (List<Employee>) emprp.findAll();
	    assertThat(emp).size().isGreaterThan(0);
	}

}
