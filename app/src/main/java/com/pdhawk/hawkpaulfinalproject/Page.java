package com.pdhawk.hawkpaulfinalproject;


public class Page {
    public int id;
    public int picture;
    public int sound;
    public int pageNumber;

    Page(int id, int picture, int sound ){
        this.id = id;
        this.picture = picture;
        this.sound = sound;
        pageNumber = id;
    }



}