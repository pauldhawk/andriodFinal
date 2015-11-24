package com.pdhawk.hawkpaulfinalproject;


import java.util.HashMap;

public class Data {
    public HashMap<Integer, Book> books;
    public HashMap<Integer, User> users;
    public HashMap<Integer, Page> pumpkinPages;
    public HashMap<Integer, Page> nightPages;
    public static final String TAG = "meBug";
    //ArrayList<BAU> baus;

    Data(){
        users =             new HashMap<Integer, User>();
        books =             new HashMap<Integer, Book>();
        pumpkinPages =      new HashMap<Integer, Page>();
        nightPages =        new HashMap<Integer, Page>();
        /// tgus us a change


        UserData();
        BookData();
        PageData();
        books.get(1).pages.putAll(pumpkinPages);
        books.get(0).pages.putAll(nightPages);
    }


    public void UserData(){
        users.put(1, new User(1,
                "Dad"
                , ""));

        users.put(2, new User(2,
                "Mom"
                , ""));

    }

    public void BookData(){
        String style = "plain";
        // Book (String title, String isbn, String description, int icon, int cover) {

        Book a = new Book(1, "Good Night Chicago",
                "030798155x",
                "Many of North America’s most beloved regions are artfully celebrated in these boardbooks designed to soothe children before bedtime while instilling an early appreciation for the continent’s natural and cultural wonders.",
                "Adam Gamble",
                R.drawable._030798155x_icon, R.drawable._030798155x_icon);


        Book b = new Book(0, "Duck & Goose, Find a Pumpkin",
                "0977797929",
                "Duck & Goose look everywhere for a ",
                "Tad Hills",
                R.drawable._0977797929_icon, R.drawable._0977797929_icon);
        books.put(a.bookId, a);
        books.put(b.bookId, b);
        int x = 4;


    }

    public void PageData() {
        pumpkinPages.put(0, new Page(0,R.drawable._030798155x_pg_01,R.raw._030798155x_aud_00));
        pumpkinPages.put(1, new Page(1,R.drawable._030798155x_pg_02,R.raw._030798155x_aud_01));
        pumpkinPages.put(2, new Page(2,R.drawable._030798155x_pg_03,R.raw._030798155x_aud_02));
        pumpkinPages.put(3, new Page(3,R.drawable._030798155x_pg_04,R.raw._030798155x_aud_03));
        pumpkinPages.put(4, new Page(4,R.drawable._030798155x_pg_05,R.raw._030798155x_aud_04));
        pumpkinPages.put(5, new Page(5,R.drawable._030798155x_pg_06,R.raw._030798155x_aud_05));
        pumpkinPages.put(6, new Page(6,R.drawable._030798155x_pg_07,R.raw._030798155x_aud_06));
        pumpkinPages.put(7, new Page(7,R.drawable._030798155x_pg_08,R.raw._030798155x_aud_07));
        pumpkinPages.put(8, new Page(8,R.drawable._030798155x_pg_09,R.raw._030798155x_aud_08));

        nightPages.put(0, new Page(0, R.drawable._0977797929_pg_01,R.raw._0977797929_aud_00));
        nightPages.put(1, new Page(1, R.drawable._0977797929_pg_02,R.raw._0977797929_aud_01));
        nightPages.put(2, new Page(2, R.drawable._0977797929_pg_03,R.raw._0977797929_aud_02));
        nightPages.put(3, new Page(3, R.drawable._0977797929_pg_04,R.raw._0977797929_aud_03));
        nightPages.put(4, new Page(4, R.drawable._0977797929_pg_05,R.raw._0977797929_aud_04));
        nightPages.put(5, new Page(5, R.drawable._0977797929_pg_06,R.raw._0977797929_aud_05));
        nightPages.put(6, new Page(6, R.drawable._0977797929_pg_07,R.raw._0977797929_aud_06));
        nightPages.put(7, new Page(7, R.drawable._0977797929_pg_08,R.raw._0977797929_aud_07));
        nightPages.put(8, new Page(8, R.drawable._0977797929_pg_09,R.raw._0977797929_aud_08));
        nightPages.put(9, new Page(9, R.drawable._0977797929_pg_10,R.raw._0977797929_aud_09));


        //   Page p0 = new Page();
        //     Page(int id, int picture, int sound ){



    }

}

