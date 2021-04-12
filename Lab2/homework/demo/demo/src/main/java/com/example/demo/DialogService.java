package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DialogService {

    private final LoginMessages messages;

    public DialogService(LoginMessages messages) {this.messages = messages;}

    public LoginMessages getLoginMessages() {return messages;}
}
