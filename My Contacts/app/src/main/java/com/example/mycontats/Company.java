package com.example.mycontats;

public class Company {
    String names;
    int images;
    public Company(String name, int image) {
        this.names = name;
        this.images = image;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    public int getImage() {
        return images;
    }

    public void setImage(int image) {
        this.images = image;
    }
}
