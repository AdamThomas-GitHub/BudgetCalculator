package com.adam.projects.budgetcalculator.MainActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.adam.projects.budgetcalculator.databasehelper.DatabaseHelper;
import com.adam.projects.budgetcalculator.slidingstabs.SlidingTabsFragment;
import com.adam.projects.budgetcalculator.slidingtabsbasic.R;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences initialPref = getSharedPreferences("INITIAL", 0);
        boolean firstRun = initialPref.getBoolean("INITIAL", true);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        //databaseHelper.insert();

        Cursor model = databaseHelper.getData();

     //   Log.i("", String.valueOf(model.));

        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SlidingTabsFragment fragment = new SlidingTabsFragment();
        transaction.replace(R.id.sample_content_fragment, fragment);
        transaction.commit();
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

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
