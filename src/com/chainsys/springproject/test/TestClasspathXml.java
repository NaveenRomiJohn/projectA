package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calender;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

import org.springframework.context.ApplicationContext; //Parent
import org.springframework.context.support.ClassPathXmlApplicationContext; //Child

public class TestClasspathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Naveen");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// Employee emp = ac.getBean(Employee.class);//overloaded method for
		// getBean(Class) returns object of the class Employee, typecasting is not
		// required
		Employee emp = (Employee) ac.getBean("emp");// overloaded method for getBean(String) returns object, typecasting
													// is required
		emp.setId(101);
		emp.setName("Romi");
		emp.print();
		Customer c = ac.getBean(Customer.class);
		c.setId(102);
		c.setName("Virat");
		c.print();
	}

	public static void testLazyInit() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp1 = ac1.getBean(Employee.class);
		Customer c1 = ac1.getBean(Customer.class);
		// lazy-init="true" for customer. An object is created now (firstcall to
		// geatBean() method for Customer.class)
		Employee emp2 = ac1.getBean(Employee.class);
		Customer c2 = ac1.getBean(Customer.class);
		System.out.println(emp1.hashCode());
		System.out.println(emp2.hashCode());
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}

	public static void prototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor heroine = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		Actor friend = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroine.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friend.hashCode());
	}

	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

	}

	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		ScoreBoard sb=ac.getBean("sb1",ScoreBoard.class);
//		sb.targetScore=183;
//		System.out.println(sb.targetScore);
//		ScoreBoard sb2=ac.getBean("sb2",ScoreBoard.class);
//		System.out.println(sb2.targetScore);
	}

	public static void testCalenderFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calender today = ac.getBean(Calender.class);
		today.day = 9;
		today.month = "June";
		today.year = 2022;
		System.out.println(today.day + "/" + today.month + "/" + today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		System.out.println("-----");
		nvsilunch.serve();
		System.out.println("-----");
		vsilunch.serve();
		System.out.println("-----");
		nilunch.serve();
		System.out.println("-----");
		chlunch.serve();
	}

	public static void testLifecycle() {
		ApplicationContext apcontext = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean life = apcontext.getBean(LifeCycleBean.class);
		life.print();
		LifeCycleBean life1 = apcontext.getBean(LifeCycleBean.class);
		LifeCycleBean life2 = apcontext.getBean(LifeCycleBean.class);
	}

	public static void testInitDestroyBean() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		InitDesposeBean init = ac1.getBean(InitDesposeBean.class);
		init.print();
	}

	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc ann = ac1.getBean(AnnotationLc.class);
		ann.print();
		ann = null;
		ac1.close();
	}

	public static void testAutoWire() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		Car car = ac1.getBean(Car.class);
		car.start();
		car.move();
		car=null;
		ac1.close();
	}
	public static void testAutowireQualifier() {
		ConfigurableApplicationContext ac1=new ClassPathXmlApplicationContext("Autowire.xml");
		CarServices cs=ac1.getBean(CarServices.class);
		cs.startTrip();
	}
	public static void testEmployee() {
		ConfigurableApplicationContext ac1=new ClassPathXmlApplicationContext("Employee.xml");
		Employee emp = ac1.getBean(Employee.class);
	}
}
