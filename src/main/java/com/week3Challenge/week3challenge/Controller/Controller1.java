package com.week3Challenge.week3challenge.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors;

import com.week3Challenge.ExceptionHandle.RecordNotFoundException;
import com.week3Challenge.week3challenge.Entity.Employee;
import com.week3Challenge.week3challenge.Service.EmpService1;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller

public class Controller1 {
	@Autowired 
private	EmpService1 empservice;
 // @ResponseBody
	@RequestMapping(value = "/home")
	public String home()
	{
		return "view" ;
		
	}
	@GetMapping("/getdetails")
  public String  getEmployee(Model m)
  {
	  List<Employee> emplist = empservice.listAll();
	    m.addAttribute("emplist", emplist);
	     
	    return "index";
  }
	@GetMapping("/emps")
	public String showSearchEmployeePage(Model model)
	{
		
		return "search";
		
	}
	@RequestMapping(value ="/get", method = RequestMethod.GET)
	  public String  getEmployee( @Param("keyword") String keyword,Model m)throws RecordNotFoundException
	  { 
	  int i=Integer.parseInt(keyword);  
	  
		  Employee  emplist= empservice.findId(i);
		
		  if(emplist != null) {
			m.addAttribute("emplist", emplist);
			
			     
			    return "index2";}
		  else {
			  m.addAttribute("emplist","Invalid id");
			  return "search";
			  
		  }
			   
		
		
		
	  }
	@RequestMapping("/addemployee")
	public String showNewEmployeePage(Model model) {
	    Employee emp = new Employee();
	    model.addAttribute("emp", emp);
	     
	    return "form";
	}
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("emp") Employee emp,Errors errors) {
		if (errors.hasErrors()) {
			return "form";
		}
		else {
	    empservice.addEmployee(emp);
	     
	    return "success";}
	}
	
}








