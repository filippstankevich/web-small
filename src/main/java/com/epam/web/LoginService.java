package com.epam.web;

public class LoginService {

    public boolean login(String user, String password){
        return "admin".equals(user) && "admin".equals(password);
    }

}
