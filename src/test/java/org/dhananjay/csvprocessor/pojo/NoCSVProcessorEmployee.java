package org.dhananjay.csvprocessor.pojo;

import org.dhananjay.csvprocessor.annotations.CSVHeaderIndex;

public class NoCSVProcessorEmployee {
	
	@CSVHeaderIndex(index=0,headerName="name")
	private String name;
	
	@CSVHeaderIndex(index=1,headerName="id")
	private long id;
	
	@CSVHeaderIndex(index=2,headerName="salary")
	private double salary;
	
	@CSVHeaderIndex(index=3,headerName="address")
	private String address;
	
	@CSVHeaderIndex(index=4,headerName="email")
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
