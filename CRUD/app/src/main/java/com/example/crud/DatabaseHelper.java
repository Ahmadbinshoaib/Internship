package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper mInstance = null;
    private Context context;

    private static final String DATABASE_NAME="DoctorDatabase";
    private static final int DATABASE_VERSION= 1;
    private static final String TABLE_DOCTORS= "doctors";
    private static final String ID= "id";
    private static final String Name= "name";
    private static final String PhoneNumber= "phonenumber";
    private static final String CNIC= "cnic";
    private static final String QUALIFICATION  = "qualification";
    private static final String SPECIALIZATION   = "specialization";

    /*
    public static DatabaseHelper getInstance(Context ctx) {

        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

     */



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create Table " + TABLE_DOCTORS + " ("
        + ID + " Integer Primary Key Autoincrement" + " , " +
          Name + " Text ," + PhoneNumber + " Text ," +  CNIC + " Text ," +
                QUALIFICATION + " Text ," + SPECIALIZATION + " Text" +  ")");

        //Open and Close
        //SQLiteDatabase sqLiteDatabase1= getWritableDatabase();
        //sqLiteDatabase1.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DOCTORS);
        onCreate(sqLiteDatabase);

    }


    public void insertDoctors(String name, String number, String cnic, String qualification, String specialization)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(PhoneNumber, number);
        contentValues.put(CNIC, cnic);
        contentValues.put(QUALIFICATION, qualification);
        contentValues.put(SPECIALIZATION, specialization);
        sqLiteDatabase.insert(TABLE_DOCTORS , null,contentValues);


    }


    public ArrayList<Doctors> fetchContact()
    {
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("Select * from " + TABLE_DOCTORS, null);

        ArrayList<Doctors> arrContacts = new ArrayList<>();
        while(cursor.moveToNext())
        {
            Doctors contactModel= new Doctors(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            arrContacts.add(contactModel);

        }
        return arrContacts;

    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_DOCTORS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String phone, String cnic, String sp, String qu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Name, name);
        cv.put(PhoneNumber, phone);
        cv.put(CNIC, cnic);
        cv.put(SPECIALIZATION, sp);
        cv.put(QUALIFICATION, qu);

        long result = db.update(TABLE_DOCTORS, cv, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_DOCTORS, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }










}
