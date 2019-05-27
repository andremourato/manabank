package com.example.provaaula11042019;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Scanner;

public class ManagerEmployeeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_employee_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating the client list
        /* Name | Balance | Score | Profile */
        //Adds the headers
        TableLayout table = (TableLayout)findViewById(R.id.history_table_employee);
        TableRow row=new TableRow(this);
        TextView tv1=new TextView(this);
        TextView tv2=new TextView(this);
        TextView tv3=new TextView(this);
        TextView arrows = new TextView(this);
        TextView tv4=new TextView(this);
        //Sets the format
        //TV1
        tv1.setText("Name");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(17);
        tv1.setTypeface(null, Typeface.BOLD);
        tv1.setGravity(Gravity.CENTER);
        //TV2
        tv2.setText("Balance");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(17);
        tv2.setTypeface(null, Typeface.BOLD);
        //TV3
        tv3.setText("Score");
        tv3.setGravity(Gravity.RIGHT);
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(17);
        tv3.setTypeface(null, Typeface.BOLD);
        //ARROWS
        arrows.setText(" ");
        arrows.setGravity(Gravity.CENTER);
        arrows.setTextColor(Color.BLACK);
        arrows.setTextSize(20);
        //TV4
        tv4.setText("Profile");
        tv4.setGravity(Gravity.CENTER);
        tv4.setTextColor(Color.BLACK);
        tv4.setTextSize(17);
        tv4.setTypeface(null, Typeface.BOLD);
        //Adds to view
        row.addView(tv1);
        row.addView(tv2);
        row.addView(tv3);
        row.addView(arrows);
        row.addView(tv4);
        System.out.println(row);
        table.addView(row);

        try {
            Scanner sc = new Scanner(getAssets().open("employee_list.csv"));
            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(";");
                addEntryToMovementHistoryTable(line[0],line[1],line[2].replace(",","."));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEntryToMovementHistoryTable(String name, String balance, String score){
        TableLayout table = (TableLayout)findViewById(R.id.history_table_client);
        TableRow row=new TableRow(this);
        TextView tv1=new TextView(this);
        TextView tv2=new TextView(this);
        TextView tv3=new TextView(this);
        TextView arrows = new TextView(this);
        ImageView tv4=new ImageView(this);
        //Sets the format
        tv1.setText(String.format("\t\t%15s\t\t",name));
        tv2.setText(String.format("%10s\t\t",balance));
        tv3.setText(String.format("%15s",score));
        if(Double.parseDouble(score)>=80){
            arrows.setText("▲\t\t\t\t");
            arrows.setTextColor(Color.GREEN);
        }else{
            arrows.setText("▼\t\t\t\t");
            arrows.setTextColor(Color.RED);
        }
        arrows.setTextSize(20);
        arrows.setTypeface(null, Typeface.BOLD);
        tv4.setImageResource(R.drawable.person_icon_small);
        tv1.setGravity(Gravity.CENTER);
        tv2.setGravity(Gravity.RIGHT);
        tv3.setGravity(Gravity.RIGHT);
        arrows.setGravity(Gravity.LEFT);
        //tv4.setGravity(Gravity.RIGHT);
        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
        //Adds to view
        row.addView(tv1);
        row.addView(tv2);
        row.addView(tv3);
        row.addView(arrows);
        row.addView(tv4);
        table.addView(row);
    }
}
