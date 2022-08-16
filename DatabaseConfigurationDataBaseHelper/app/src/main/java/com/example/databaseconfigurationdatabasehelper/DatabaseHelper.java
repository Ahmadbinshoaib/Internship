package com.example.databaseconfigurationdatabasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper mInstance = null;

    private static final String DATABASE_NAME="Contacts";
    private static final int DATABASE_VERSION= 1;
    private static final String TABLE_CONTACTS= "phonecontacts";
    private static final String ID= "id";
    private static final String Name= "name";
    private static final String PhoneNumber= "phonenumber";

    public static DatabaseHelper getInstance(Context ctx) {
        /**
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information:
         * http://android-developers.blogspot.nl/2009/01/avoiding-memory-leaks.html)
         */
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }


    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create Table " + TABLE_CONTACTS + " ("
        + ID + " Integer Primary Key Autoincrement" + " , " +
          Name + " Text ," + PhoneNumber + " Text " +               ")");

        //Open and Close
        //SQLiteDatabase sqLiteDatabase1= getWritableDatabase();
        //sqLiteDatabase1.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(sqLiteDatabase);

    }

    public void insertContacts(String name, String number)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(PhoneNumber, number);
        sqLiteDatabase.insert(TABLE_CONTACTS , null,contentValues);

    }

    public ArrayList<ContactModel> fetchContact()
    {
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("Select * from " + TABLE_CONTACTS, null);

        ArrayList<ContactModel> arrContacts = new ArrayList<>();
        while(cursor.moveToNext())
        {
            ContactModel contactModel= new ContactModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2) );
            arrContacts.add(contactModel);

        }
        return arrContacts;

    }


}
