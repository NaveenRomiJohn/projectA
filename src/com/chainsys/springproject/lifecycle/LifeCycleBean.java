package com.chainsys.springproject.lifecycle;

public class LifeCycleBean {
	public LifeCycleBean() {
		System.out.println("LifecycleBean is called ");
	}

	public void print() {
		System.out.println("print called");
	}
	public void setUp() {
		System.out.println("Starting....");
	}
	public void close() {
		System.out.println("Closing....");
	}
}
