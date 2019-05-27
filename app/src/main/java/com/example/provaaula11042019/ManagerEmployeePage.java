package com.example.provaaula11042019;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Scanner;

public class ManagerEmployeePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_employee_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //Creating the client list
        /* Name | Balance | Score | Profile */
        //Adds the headers
        TableLayout table = (TableLayout)findViewById(R.id.history_table_employee);
        TableRow row=new TableRow(this);
        TextView tv1=new TextView(this);
        TextView tv2=new TextView(this);
        //TextView tv3=new TextView(this);
        TextView arrows = new TextView(this);
        //TextView tv4=new TextView(this);
        //Sets the format
        //TV1
        tv1.setText("Name");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(22);
        tv1.setTypeface(null, Typeface.BOLD);
        tv1.setGravity(Gravity.CENTER);
        //TV2
        tv2.setText("Revenue (€)");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(22);
        tv2.setTypeface(null, Typeface.BOLD);
        //TV3
        //tv3.setText("Score");
        //tv3.setGravity(Gravity.RIGHT);
        //tv3.setTextColor(Color.BLACK);
        //tv3.setTextSize(17);
        //tv3.setTypeface(null, Typeface.BOLD);
        //ARROWS
        arrows.setText(" ");
        arrows.setGravity(Gravity.CENTER);
        arrows.setTextColor(Color.BLACK);
        arrows.setTextSize(20);
        //TV4
        //tv4.setText("Profile");
        //tv4.setGravity(Gravity.CENTER);
        //tv4.setTextColor(Color.BLACK);
        //tv4.setTextSize(17);
        //tv4.setTypeface(null, Typeface.BOLD);
        //Adds to view
        row.addView(tv1);
        row.addView(tv2);
        //row.addView(tv3);
        row.addView(arrows);
        //row.addView(tv4);
        System.out.println(row);
        table.addView(row);

        try {
            Scanner sc = new Scanner(getAssets().open("employee_list.csv"));
            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(";");
                addEntryToMovementHistoryTable(line[0],line[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEntryToMovementHistoryTable(String name, String revenue){
        TableLayout table = (TableLayout)findViewById(R.id.history_table_employee);
        TableRow row=new TableRow(this);
        TextView tv1=new TextView(this);
        TextView tv2=new TextView(this);
        //TextView tv3=new TextView(this);
        TextView arrows = new TextView(this);
        //ImageView tv4=new ImageView(this);
        //Sets the format
        tv1.setText(String.format("\t\t\t\t\t\t\t%15s\t\t\t\t\t\t\t\t\t\t\t",name));
        tv2.setText(String.format("%10s\t\t\t\t\t\t\t\t\t\t",revenue));
        //tv3.setText(String.format("%15s",score));
        if(Double.parseDouble(revenue)>=45){
            arrows.setText("▲\t\t\t\t");
            arrows.setTextColor(Color.GREEN);
        }else{
            arrows.setText("▼\t\t\t\t");
            arrows.setTextColor(Color.RED);
        }
        arrows.setTextSize(20);
        arrows.setTypeface(null, Typeface.BOLD);
        //tv4.setImageResource(R.drawable.person_icon_small);
        tv1.setGravity(Gravity.CENTER);
        tv2.setGravity(Gravity.RIGHT);
        //tv3.setGravity(Gravity.RIGHT);
        arrows.setGravity(Gravity.LEFT);
        //tv4.setGravity(Gravity.RIGHT);
        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
        //tv3.setTextColor(Color.BLACK);
        //Adds to view
        row.addView(tv1);
        row.addView(tv2);
        //row.addView(tv3);
        row.addView(arrows);
        //row.addView(tv4);
        table.addView(row);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
