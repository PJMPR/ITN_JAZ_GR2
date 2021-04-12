package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Component
public class DialogService {

    private final LoginMessages messages;

    public DialogService(LoginMessages messages) { this.messages = messages;}

    public LoginMessages getLoginMessages() {return messages;}
}
