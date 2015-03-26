package com.adam.projects.budgetcalculator.mainactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.adam.projects.budgetcalculator.databasehelper.DatabaseHelper;
import com.adam.projects.budgetcalculator.slidingstabs.SlidingTabsFragment;

import static com.adam.projects.budgetcalculator.mainactivity.R.id.submit_button;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SlidingTabsFragment fragment = new SlidingTabsFragment();
        transaction.replace(R.id.sample_content_fragment, fragment);
        transaction.commit();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        Cursor model = databaseHelper.getData();

        while(model.moveToNext()) {
            Log.i("", String.valueOf(model.getInt(0)));
            Log.i("", String.valueOf(model.getString(1)));
            Log.i("", String.valueOf(model.getInt(2)));
            Log.i("", String.valueOf(model.getString(3)));
            Log.i("", String.valueOf(model.getString(4)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
