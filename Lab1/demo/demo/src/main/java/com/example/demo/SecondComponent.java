package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class SecondComponent {

    FirstComponent firstComponent;
    public SecondComponent(FirstComponent firstComponent) {
        this.firstComponent = firstComponent;
        System.out.println("second created");
    }


    public void printMe(){
        firstComponent.printMe();
        System.out.println("second");
    }
}
