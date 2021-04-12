package com.example.demo;

public class DialogService {
    LoginMessages messages;

    public LoginMessages getLoginMessages() {
        return messages;
    }

    public DialogService(LoginMessages messages) {
        this.messages = messages;
    }

    public void setLoginMessages(LoginMessages messages) {
        this.messages = messages;
    }
}