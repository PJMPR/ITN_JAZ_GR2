package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DialogService {
    private LoginMessages messages;

    public DialogService(LoginMessages messages) {
        this.messages = messages;
    }

    public LoginMessages getLoginMessages() {
        return messages;
    }
}
