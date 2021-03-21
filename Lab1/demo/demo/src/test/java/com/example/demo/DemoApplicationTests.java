package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests extends Mockito {

	@Test
	void annotationsTest() {

		//Utwórz klase Person
		Person person = new Person();
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.example.demo");
		context.refresh();

		//Utwórz klase PersonDb. Oznacz ją jako komponent
		//pobierz ją z kontekstu DI Springa
		PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());

		//Utwórz klasę PersonRepository. Oznacz ją jako komponent.
		//pobierz ją z kontekstu DI Springa
		PersonRepository repository = context.getBean(PersonRepository.class);

		//Zapisz osobę do bazy
		repository.save(person);

		//pobranie obiektu PersonDb z repository
		db = repository.getDb();
		// z PersonDb bierzemy kolekcje osób
		Person[] list = db.getPersonArray();
		//sprawdzamy czy zapisana osoba jest w kolekcji
		//sprawdzamy czy kolekcja ma rozmiar 1000
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);

	}

	@Test
	void beanConfigTest(){
		Person person = new Person();
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


		PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());

		PersonRepository repository = context.getBean(PersonRepository.class);

		repository.save(person);
		db = repository.getDb();
		Person[] list = db.getPersonArray();
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);
	}

}
