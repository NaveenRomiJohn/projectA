package com.chainsys.springproject.autowire;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
public class Car {
	@Autowired
	private Engine petrolEngine;
	@Resource
	private Wheel alloy;

	public Car() {
		System.out.println("Car object Created " + hashCode());
	}
	public void begin() {
		System.out.println("Start AnnotationLc...");
	}
	public void stop() {
		System.out.println("Stop AnnotationLc...");
	}

	public void start() {
		petrolEngine.start();
	}

	public void move() {
		alloy.rotate();
	}
}

@Component("SportsCar")
class SportsCar extends Car {
	public SportsCar() {
		System.out.println("SportsCar object created "+hashCode());
	}
}

@Component("SuvCar")
class SuvCar extends Car {
	public SuvCar() {
		System.out.println("SuvCar object created "+hashCode());
	}
}
