package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class FirstComponent {

    public FirstComponent() {
        System.out.println("first created");
    }

    public void printMe(){
        System.out.println("first");
    }

}