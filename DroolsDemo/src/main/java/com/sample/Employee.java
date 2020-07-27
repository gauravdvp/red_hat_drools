package com.sample;

import java.util.List;

public class Employee {
	private String name;
	private Integer age;
	private SkillSet skillSet;
	private List<Integer> ctc;
	private List<Address> address;

	public Employee(String name, List<Address> address, Integer age, SkillSet skillSet,List<Integer> ctc) {
		super();
		this.age = age;
		this.name = name;
		this.ctc=ctc;
		this.skillSet = skillSet;
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

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setCtc(List<Integer> ctc) {
		this.ctc = ctc;
	}

	public List<Integer> getCtc() {
		return ctc;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", skillSet=" + skillSet + ", ctc=" + ctc + ", address="
				+ address + "]";
	}
	
}