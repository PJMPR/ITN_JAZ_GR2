package pl.pjatk.jak;

import org.springframework.stereotype.Component;

@Component
public class SecondComponent {

    FirstComponent firstComponent;
    public SecondComponent(FirstComponent firstComponent) {
        System.out.println("SecondComponent");
    }

//    public void printMe(){
//        System.out.println("SecondComponent.printMe");
//    }
}
