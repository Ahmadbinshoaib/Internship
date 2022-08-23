package com.example.apiuserauthenticationmvvmarhitecture.request;

public class LogInRequest {
    private String email, password;

    public String getEmail() {
        return email;
    }

    public LogInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
