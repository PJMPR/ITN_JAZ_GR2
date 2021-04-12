package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {

    private String selectedUser;

    @Value("${message.welcome}")
    String welcomeMessage;

    @Value("${message.prompt}")
    String promptMessage;

    @Value("${message.loggedAs}")
    String loggedAsMessage;

    public String welcome(){
        return welcomeMessage;
    }

    public String getUsernameMessage(){
        return promptMessage;
    }

    public void setUsername(String username){
        selectedUser = username;
    }

    public String getLoggedAsMessage(){
        return loggedAsMessage + " " + selectedUser;
    }

}
