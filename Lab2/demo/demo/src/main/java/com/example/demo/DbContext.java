package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class DbContext {

    String url;
    String user;
    String password;
    @Value("${db.mysql.timeout:60}")
    int timeout;

    public DbContext(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getConnectionString(){
        return "server=" +
                url +
                ";user=" +
                user +
                ";password=" +
                password+
                ";timeout=" +
                timeout
                ;
    }
}
