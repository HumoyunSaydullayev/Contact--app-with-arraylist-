package com.example.mycontats;

import android.content.Context;

import java.util.ArrayList;

public class User {
    String name,last,number,email,type,company,country;
    int imageId;

    public User(String name, String last, String number, String email, String type, String company, String country, int imageId) {
        this.name = name;
        this.last = last;
        this.number = number;
        this.email = email;
        this.type = type;
        this.company = company;
        this.country = country;
        this.imageId = imageId;
    }

}
