package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {

    @Value("${message.welcome}") String welcome;
    private String username;
    @Value("${message.prompt}") String prompt;
    @Value("${message.loggedAs}") String loggedAs;

    public String getUsernameMessage() {
        return prompt;
    }

    public String getLoggedAsMessage() {
        return loggedAs + " " + username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String welcome() {
        return welcome;
    }
}
