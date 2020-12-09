package com.example.bts530;


public class UserAccounts {

    private int id;
    private String email;
    private String password;

    public UserAccounts(){}

    /*public UserAccounts(String email){

        this.email=email;
    }*/

    public UserAccounts(String password){

        this.password=password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
