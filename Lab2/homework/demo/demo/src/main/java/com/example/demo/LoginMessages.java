package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class LoginMessages {
    private String username;
    @Value("${application.messages.welcome}")
    private String welcomeMessage;
    @Value("${application.messages.provideUsername}")
    private String usernameMessage;
    @Value("${application.messages.loggedAs}")
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
