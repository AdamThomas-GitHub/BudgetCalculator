package com.adam.projects.budgetcalculator.databasehelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "budgetcalculator.db";
    private static final int SCHEMA_VERSION=1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("INFO", "Creating Database");
        db.execSQL("CREATE TABLE expenses (_id INTEGER PRIMARY KEY AUTOINCREMENT, timeStamp TEXT, value INTEGER, type TEXT ,user TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert() {

        ContentValues cv=new ContentValues();
        cv.put("timeStamp", "2015-03-11 13:00:00");
        cv.put("value", "25.00");
        cv.put("type", "Rent");
        cv.put("user", "Adam");

        getWritableDatabase().insert("expenses", "name", cv);
    }

    public android.database.Cursor getData(){
        return (getReadableDatabase().rawQuery("Select * from expenses", null));
    }
    }

