package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class ThirdComponent {

    SecondComponent secondComponent;
    public ThirdComponent(SecondComponent secondComponent) {
        this.secondComponent = secondComponent;
        System.out.println("third created");
    }

    public void printMe(){
        this.secondComponent.printMe();
        System.out.println("third");
    }
}
