package com.week3Challenge.week3challenge.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	private int id;
	 @Column
	@NotNull
	@Size(min = 2, max = 10, message = "length shoud be in between 2 to 10")
	private String forename;
	@Column
	@NotEmpty(message = " surnamne is not empty")
	private String surname;
	@Column
	@Min(value=18, message="must be equal or greater than 25")  
    @Max(value=45, message="must be equal or less than 45")  
	private int age;
	@Column
	@NotEmpty(message = "Company field should not be empty")
	private String company;
	@Column
	@NotEmpty(message = "Postcode field should not be empty")
	private String postcode;
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String forename, String surname, int age, String company, String postcode) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.age = age;
		this.company = company;
		this.postcode = postcode;
	}

	

}
