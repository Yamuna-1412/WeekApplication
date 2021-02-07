package com.week3Challenge.week3challenge.TestController;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.week3Challenge.week3challenge.Controller.Controller1;
import com.week3Challenge.week3challenge.Controller.ControllerRest;
import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Repository.EmployeeRepository;
import com.week3Challenge.week3challenge.Service.EmpService1;
import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@WebMvcTest(ControllerRest.class)
class TestController {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeRepository emprepo;
	@MockBean
	private EmpService1 empSer;
     @Test
     public void testGetEmployees() throws Exception
     {
    	 Employee e=new Employee();
    	 e.setId(1);
 		e.setForename("Ram");
 		e.setForename("Mal");
 		e.setAge(22);
 		e.setCompany("TCS");
 		e.setPostcode("12121");
 		Employee e2=new Employee();
 		e2.setId(2);
 		e2.setForename("Nikki");
 		e2.setForename("Mal");
 		e2.setAge(22);
 		e2.setCompany("TCS");
 		e2.setPostcode("12121");
 		List<Employee> elist=new ArrayList<>();
 		elist.add(e);
 		elist.add(e2);
 		
 		Mockito.when(empSer.listAll()).thenReturn(elist);
 		
		String URI = "/empser";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(elist);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		System.out.print(outputInJson);
     }
     @Test
     public void updateEmployee() throws Exception
     {
    	 Employee e=new Employee();
    	 int id=1;
    	 e.setId(1);
 		e.setForename("Ram");
 		e.setSurname("Mala");;
 		e.setAge(22);
 		e.setCompany("TCS");
 		e.setPostcode("12121");
 		Optional<Employee> e1=Optional.of(e);
 		Mockito.when(emprepo.findById(id)).thenReturn(e1);
 		
 		Mockito.when(empSer.updateEmployee(id,e)).thenReturn(e1);
 		
 		 String URI="/emp/{id}";
 		String expectedJson = this.mapToJson(e);
		
 		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/emp/"+id).accept(MediaType.APPLICATION_JSON).content(expectedJson)
				.contentType(MediaType.APPLICATION_JSON);;
				MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
				MockHttpServletResponse response = result.getResponse();
				String outputInJson = response.getContentAsString();
				
				
				assertEquals(HttpStatus.OK.value(), response.getStatus());
     }
     private String mapToJson(Object object) throws JsonProcessingException {
 		ObjectMapper objectMapper = new ObjectMapper();
 		return objectMapper.writeValueAsString(object);
 	}
}
