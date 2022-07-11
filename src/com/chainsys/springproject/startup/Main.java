package com.chainsys.springproject.startup;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.view.EmployeeController;

public class Main {

	public static void main(String[] args) {
		employeeMenu();
	}
	
	public static void employeeMenu() {
		ConfigurableApplicationContext apcontext=new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeController empController = apcontext.getBean(EmployeeController.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("1) To add New employee into table");
		System.out.println("2) To Get employee datails by id from the table");
		System.out.println("3) To Update employee details");
		System.out.println("4) To Delete Employee details");
		int Case=sc.nextInt();
		switch(Case) {
		case 1:
			empController.addNewEmployee();
			break;
		case 2:
			empController.getEmployeeById();
			break;
		case 3:
			empController.updateEmployee();
			break;
		case 4:
			empController.deleteEmployee();
			break;
		default:
			System.out.println("Enter valid case number");
		}
		apcontext.close();
		sc.close();
	}
}