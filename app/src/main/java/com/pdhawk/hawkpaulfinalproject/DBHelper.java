//package com.pdhawk.hawkpaulfinalproject;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//
//public class DBHelper extends SQLiteOpenHelper {
//    public static final String TAG = "meBug";
//    // If you change the database schema, you must increment the database version.
//    public static final int DATABASE_VERSION = 1;
//    public static final String DATABASE_NAME = "Reader";
//
//    public DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(DB.Books.SQL_CREATE_BOOK);
//        db.execSQL(DB.Pages.SQL_CREATE_PAGE);
//    }
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // This database is only a cache for online data, so its upgrade policy is
//        // to simply to discard the data and start over
//        db.execSQL(DB.Pages.SQL_DELETE_PAGES);
//        db.execSQL(DB.Books.SQL_DELETE_BOOK);
//        onCreate(db);
//    }
//    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        onUpgrade(db, oldVersion, newVersion);
//    }
//
//    public void addPage(Page p, int bookId ) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(DB.Pages.C_ID, p.id);
//        values.put(DB.Pages.C_PAGE_NUMBER, p.pageNumber);
//        values.put(DB.Pages.C_PICTURE, p.picture);
//        values.put(DB.Pages.C_SOUND, p.sound);
//        values.put(DB.Pages.C_BOOK_ID, bookId);
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId;
//        newRowId = db.insert(
//                DB.Pages.TABLE_NAME,
//                null,
//                values);
//        Log.d(TAG, "addPage id number " + newRowId);
//        db.close();
//
//
//
//    }
//
//}
