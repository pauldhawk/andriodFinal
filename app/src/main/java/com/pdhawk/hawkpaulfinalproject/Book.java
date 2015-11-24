package com.pdhawk.hawkpaulfinalproject;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class Book {
    public int              bookId;
    public String           title;
    public String           isbn;
    public int              icon;
    public int              cover;
    public String           description;

    int currentPage = 0;
    int totalPages;

    // if i get to it
    public ArrayList<User>  user;
    public String           author; // simpliyint to single author so just need name
    public String           style;
    public HashMap<Integer, Page> pages;







    Book () {}



    Book (int id , String title, String isbn, String description, String author, int icon, int cover) {

        this.bookId = id;
        this.title = title;
        this.isbn = isbn;
        this.cover = cover;
        this.icon = icon;
        this.description = description;
        this.author = author;
        this.pages =  new HashMap<Integer, Page>();
        this.totalPages = pages.size();
    }

    public Page getNextPage(){
        Log.d("MeBug", "total pages " + pages.size());
        if (currentPage < pages.size()-1) { currentPage++;}
        return pages.get(currentPage);

    }
    public Page getPrevPage(){
        if (currentPage > 0) { currentPage--;}
        return pages.get(currentPage);
    }
    public void setName(String title) {
        this.title = title;
    }
    public String getName() { return title; }


    public String getShortDescription() {
        return description.length() > 50 ? description.substring(0,50) : description;
    }
    public String getLongDescription() {
        return description;
    }
    public void setLongDescription(String longDescription) {
        this.description = longDescription;
    }


}
