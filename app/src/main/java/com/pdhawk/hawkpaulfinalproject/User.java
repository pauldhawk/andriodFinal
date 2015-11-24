package com.pdhawk.hawkpaulfinalproject;

import java.util.ArrayList;

public class User {
    public int userId;
    public String name;
    public String picture;
    public String bio;
    public ArrayList<Book> books;

    User() {}
    User(int id, String name, String bio) {
        this.userId = id;
        this.name = name;
        this.picture = id + ".png";
        this.bio = bio;
    }


}