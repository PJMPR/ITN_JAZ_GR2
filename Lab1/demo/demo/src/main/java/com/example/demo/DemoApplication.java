package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);

		Person person = new Person();
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.example.demo");
//		context.refresh();

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		PersonDb db = context.getBean(PersonDb.class);
		PersonRepository repository = context.getBean(PersonRepository.class);
		repository.save(person);
		db = repository.getDb();
		Person[] list = db.getPersonArray();
	}

}
