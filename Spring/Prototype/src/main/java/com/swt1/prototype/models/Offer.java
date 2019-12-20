package com.swt1.prototype.models;

public class Offer {

    private String user;
    private String description;
    private String price;
    private boolean accepted;
    private String documentID;

    public Offer(String user, String description, String price, String documentID) {
        this.user = user;
        this.description = description;
        this.price = price;
        this.accepted = false;
        this.documentID = documentID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }
}

