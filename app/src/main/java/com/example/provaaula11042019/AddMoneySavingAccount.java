package com.example.provaaula11042019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddMoneySavingAccount extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Spinner spinnerId;
    EditText editAmm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money_saving_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addItemsOnSpinner();

        editAmm = (EditText)findViewById(R.id.editText17);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void addItemsOnSpinner() {

        spinnerId = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Account");
        list.add("60 Days - 120€");
        list.add("90 Days - 300€");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerId.setAdapter(dataAdapter);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_personal_page_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAddMoney(View view){

        Intent intentHome = new Intent(this, PersonalPage.class);

        Toast.makeText(this,"Money add sent ",Toast.LENGTH_LONG).show();
        editAmm.setText("");
          //  editId.setText("");

        startActivity(intentHome);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_history) {


            Intent intentPay = new Intent(this, PaymentHistory.class);
            startActivity(intentPay);

        } else if (id == R.id.nav_service_pay) {

            Intent intentService = new Intent(this, ServicePayments.class);
            startActivity(intentService);

        } else if (id == R.id.nav_create_saving_account) {


              Intent intentSaving = new Intent(this, CreateSeavingAccounts.class);
              startActivity(intentSaving);

        }  else if (id == R.id.nav_home) {


            Intent intentHome = new Intent(this, PersonalPage.class);
            startActivity(intentHome);
        }else if(id == R.id.nav_transfer){

            Intent intentTrans = new Intent(this, TransfertPage.class);
            startActivity(intentTrans);

        }else if(id == R.id.nav_add_money){



        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
