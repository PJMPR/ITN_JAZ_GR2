package pl.pjatk.jak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PruApplication {

	public static void main(String[] args) {


//		SpringApplication.run(PruApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("pl.pjatk.jak");
//		context.refresh();

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		NewComponent newComponent = context.getBean(NewComponent.class);
//		NewComponent newComponent = new NewComponent(context);
	}

}
