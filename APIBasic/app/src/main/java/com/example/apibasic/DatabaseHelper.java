package com.example.apibasic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper mInstance = null;
    private Context context;

    private static final String DATABASE_NAME="DoctorDatabase";
    private static final int DATABASE_VERSION= 1;
    private static final String TABLE_NAME= "posts";
    private static final String USERID= "userid";
    private static final String ID= "id";
    private static final String TITLE= "title";
    private static final String BODY= "body";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create Table " + TABLE_NAME + " ("
                + ID + " Text " + " , " +
                USERID + " Text ," + TITLE + " Text ," +  BODY + " Text " + " )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertPosts(String id, String userid, String title, String body)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(USERID, userid);
        contentValues.put(TITLE, title);
        contentValues.put(BODY, body);
        sqLiteDatabase.insert(TABLE_NAME , null,contentValues);


    }

    public ArrayList<Structure> fetchContact()
    {
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("Select * from " + TABLE_NAME, null);

        ArrayList<Structure> arrContacts = new ArrayList<>();
        while(cursor.moveToNext())
        {
            Structure contactModel= new Structure(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3));
            arrContacts.add(contactModel);

        }
        return arrContacts;

    }
}
