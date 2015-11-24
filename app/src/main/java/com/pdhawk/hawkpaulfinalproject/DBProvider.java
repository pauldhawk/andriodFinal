//package com.pdhawk.hawkpaulfinalproject;
//
//import android.content.ContentProvider;
//import android.content.ContentResolver;
//import android.content.ContentValues;
//import android.database.Cursor;
//import android.net.Uri;
//
///**
// * Created by phawk on 11/24/15.
// */
//public class DBProvider  extends ContentProvider {
//    private DBHelper db;
//    private static final String AUTHORITY = "com.pdhawk.com.data";
//    public static final int DBs = 100;
//    public static final int DB_ID = 110;
//
//    private static final String DB_BASE_PATH = "db";
//    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
//            + "/" + DB_BASE_PATH);
//
//    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
//            + "/readerdb";
//    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
//            + "/readerdb";
//
//    @Override
//    public boolean onCreate() {
//        db = new DBHelper(getContext());
//        return true;
//    }
//
//    @Override
//    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//        return null;
//    }
//
//    @Override
//    public String getType(Uri uri) {
//        return null;
//    }
//
//    @Override
//    public Uri insert(Uri uri, ContentValues values) {
//        return null;
//    }
//
//    @Override
//    public int delete(Uri uri, String selection, String[] selectionArgs) {
//        return 0;
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
//        return 0;
//    }
//}
