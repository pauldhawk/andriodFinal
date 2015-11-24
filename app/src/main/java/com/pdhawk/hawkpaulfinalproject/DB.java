package com.pdhawk.hawkpaulfinalproject;

import android.provider.BaseColumns;

/**
 * Created by phawk on 11/23/15.
 */
public class DB {
    public  DB(){}

    public static abstract class Pages implements BaseColumns {
        public static final String TABLE_NAME = "pages";
        public static final String C_ID = "_id";
        public static final String C_PAGE_NUMBER = "page_number";
        public static final String C_PICTURE = "picture";
        public static final String C_SOUND = "sound";
        public static final String C_BOOK_ID = "book_id";

        public static final String SQL_CREATE_PAGE =
                "_id INTEGER PRIMARY KEY " +
                        ", page_number INTEGER " +
                        ", picture Integer not null " +
                        ", sound Integer not null " +
                        ",  book_id Integer " +
                        ", FOREIGN KEY( book_id) REFERENCES books(_id) " +
                        "); ";

        public static final String SQL_DELETE_PAGES =
                                    " drop table if exists pages; " ;
    }

    public static abstract class Books implements BaseColumns {
        public static final String TABLE_NAME = "books";
        public static final String C_ID = "_id";
        public static final String C_TITLE = "title";
        public static final String C_DESCRIPTION = "description";
        public static final String C_ICON = "icon";
        public static final String C_COVER = "cover";
        public static final String C_ISBDN = "isbdn";
        public static final String C_AUTHOR = "author";

        public static final String SQL_CREATE_BOOK =
                    "create table books ( " +
                            "     _id INTEGER PRIMARY KEY " +
                            "     , title varchar not null " +
                            "     , description varchar " +
                            "     , icon INTEGER " +
                            "     , cover INTEGER " +
                            "     , isbdn TEXT " +
                            "     , author TEXT " +
                            "  ); ";

        public static final String SQL_DELETE_BOOK =
                                     " drop table if exists books; " ;

    }



}
