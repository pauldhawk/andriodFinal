package com.pdhawk.hawkpaulfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phawk on 11/24/15.
 */
public class DBSingle extends SQLiteOpenHelper {
    public static final String TAG = "meBug";
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Reader";

    private static DBSingle ourInstance;

    public static DBSingle getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new DBSingle(context.getApplicationContext());
        }
        return ourInstance;
    }

    private DBSingle(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB.Books.SQL_CREATE_BOOK);
        db.execSQL(DB.Pages.SQL_CREATE_PAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DB.Pages.SQL_DELETE_PAGES);
        db.execSQL(DB.Books.SQL_DELETE_BOOK);
        onCreate(db);
    }


    public void addPage(Page p, int bookId ) {
    SQLiteDatabase db = this.getWritableDatabase();

    db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(DB.Pages.C_ID, p.id);
            values.put(DB.Pages.C_PAGE_NUMBER, p.pageNumber);
            values.put(DB.Pages.C_PICTURE, p.picture);
            values.put(DB.Pages.C_SOUND, p.sound);
            values.put(DB.Pages.C_BOOK_ID, bookId);

            // Insert the new row, returning the primary key value of the new row
            long newRowId;
            newRowId = db.insertOrThrow(
                    DB.Pages.TABLE_NAME,
                    null,
                    values);
            db.setTransactionSuccessful();
            Log.d(TAG, "addPage id number " + newRowId);

        } catch (Exception e) {
            Log.d(TAG, "Error adding page to be");
        } finally {

            db.endTransaction();

        }
    }


    public long addOrUpdatePage(Page p, int bookId) {
        SQLiteDatabase db = getWritableDatabase();
        long id = -1;


// TODO: 11/24/15 fix select statment
        db.beginTransaction();
        try {
            // see if alread in db
            ContentValues values = new ContentValues();
            values.put(DB.Pages.C_PAGE_NUMBER, p.pageNumber);
            values.put(DB.Pages.C_BOOK_ID, bookId);

            int rows = db.update(DB.Pages.TABLE_NAME,
                                values,
                                DB.Pages.C_BOOK_ID + "= ?",
                                new String[]{ Integer.toString(p.pageNumber) });

            if (rows == 1) {
                // Get the primary key of the user we just updated
                String pageSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        DB.Pages.C_ID, DB.Pages.TABLE_NAME, DB.Pages.C_ID);
                Cursor cursor = db.rawQuery(pageSelectQuery, new String[]{String.valueOf(Integer.toString(p.pageNumber))});
                try {
                    if (cursor.moveToFirst()) {
                        id = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }

            } else {
                // user with this userName did not already exist, so insert new user
                id = db.insertOrThrow(DB.Pages.TABLE_NAME, null, values);
                db.setTransactionSuccessful();
            }

        } catch (Exception e){
            Log.d(TAG, "Error checking if record is already in db");
        }finally {
            db.endTransaction();
        }
        return id;
    }



    public List<Page> getAllPosts() {
        List<Page> posts = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        DB.Pages.TABLE_NAME,
                        DB.Pages.TABLE_NAME,
                        DB.Books.TABLE_NAME, DB.Pages.C_BOOK_ID,
                        DB.Books.TABLE_NAME, DB.Books.C_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Page newPage = new Page();
                    newPage.id = cursor.getInt(cursor.getColumnIndex(DB.Pages.C_ID));
                    newPage.bookId = cursor.getInt(cursor.getColumnIndex(DB.Pages.C_BOOK_ID));

//                    Book newPost = new Post();
//                    newPost.text = cursor.getString(cursor.getColumnIndex(KEY_POST_TEXT));
//                    newPost.user = newPage;
//                    posts.add(newPost);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return posts;
    }
    //    public int updateUserProfilePicture(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_USER_PROFILE_PICTURE_URL, user.profilePictureUrl);
//
//        // Updating profile picture url for user with that userName
//        return db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
//                new String[] { String.valueOf(user.userName) });
    //   }
//
//    public void deleteAllPostsAndUsers() {
//        SQLiteDatabase db = getWritableDatabase();
//        db.beginTransaction();
//        try {
//            // Order of deletions is important when foreign key relationships exist.
//            db.delete(TABLE_POSTS, null, null);
//            db.delete(TABLE_USERS, null, null);
//            db.setTransactionSuccessful();
//        } catch (Exception e) {
//            Log.d(TAG, "Error while trying to delete all posts and users");
//        } finally {
//            db.endTransaction();
//        }
//    }
//}


}
