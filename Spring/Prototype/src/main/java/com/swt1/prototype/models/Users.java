package com.swt1.prototype.models;

public class Users{

    private String name;
    private String username;
    private String email;
    private String password;
    private String documentID;



    public Users(String name, String username, String email, String password, String documentID) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.documentID = documentID;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }
}