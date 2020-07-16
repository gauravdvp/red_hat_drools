package com.sample;

import java.util.List;

public class Employee {
	private String name;
	private List<Address> address;

	public Employee(String name, List<Address> address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}