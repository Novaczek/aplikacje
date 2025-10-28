package com.example.lekcja12_recyclerview3;


public class User {
    private String firstName;
    private String lastName;
    private String imageId;

    public User(String firstName, String lastName,String imageId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageId = imageId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageId() {
        return this.imageId;
    }
}
