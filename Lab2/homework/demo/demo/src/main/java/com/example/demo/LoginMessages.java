package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class LoginMessages {
    private String username;

    @Value("${messages.welcome}")
    private String welcomeMessage;

    @Value("${messages.username}")
    private String usernameMessage;

    @Value("${messages.loggedAs}")
    private String loggedAsMessage;

    public String getUsernameMessage() {
        return usernameMessage;
    }

    public String getLoggedAsMessage() {
        return loggedAsMessage + " " + getUsername();
    }

    public String welcome() {
        return welcomeMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}