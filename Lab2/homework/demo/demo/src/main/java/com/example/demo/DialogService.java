package com.example.demo;

public class DialogService {
    LoginMessages loginMessages;

    public LoginMessages getLoginMessages(){
        return loginMessages;
    }

    public DialogService(LoginMessages loginMessages){
        this.loginMessages = loginMessages;
    }

    public void setLoginMessages(LoginMessages loginMessages) {
        this.loginMessages = loginMessages;
    }
}
