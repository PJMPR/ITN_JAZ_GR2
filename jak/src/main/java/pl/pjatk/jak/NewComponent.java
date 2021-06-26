package pl.pjatk.jak;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NewComponent {
    public NewComponent(ApplicationContext applicationContext) {
        FirstComponent firstComponent = applicationContext.getBean("firstComponent", FirstComponent.class);
        SecondComponent secondComponent = applicationContext.getBean("secondComponent", SecondComponent.class);
        firstComponent.printMe();
        secondComponent.printMe();
    }
}
