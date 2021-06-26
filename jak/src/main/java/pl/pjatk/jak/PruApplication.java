package pl.pjatk.jak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PruApplication {

	public static void main(String[] args) {


		SpringApplication.run(PruApplication.class, args);

//		SecondComponent secondComponent = new SecondComponent(firstComponent);

	}

}
