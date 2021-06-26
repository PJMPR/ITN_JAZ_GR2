package pl.pjatk.jak;

import org.springframework.stereotype.Component;

@Component
public class SecondComponent {

    FirstComponent firstComponent;
    public SecondComponent(FirstComponent firstComponent) {
        this.firstComponent = firstComponent;
        System.out.println("SecondComponent");
    }


}
