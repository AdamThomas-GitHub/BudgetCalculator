package com.adam.projects.budgetcalculator.databasehelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public void insert(Integer value, String type, String user) {


        ContentValues cv=new ContentValues();
        cv.put("timeStamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        cv.put("value", value);
        cv.put("type", type);
        cv.put("user", user);

        getWritableDatabase().insert("expenses", "name", cv);
    }

    public android.database.Cursor getData(){
        return (getReadableDatabase().rawQuery("Select * from expenses", null));
    }
    }

