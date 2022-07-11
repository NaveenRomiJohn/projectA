package com.chainsys.springproject.beans;

public class Employee {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public void print() {
		System.out.println("Employee ID  : "+this.getId());
		System.out.println("Employee Name: "+this.getName());
	}
	public Employee() {
		System.out.println("Employee object created "+ hashCode());
	}
}
