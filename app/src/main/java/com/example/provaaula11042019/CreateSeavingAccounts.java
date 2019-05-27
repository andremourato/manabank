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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateSeavingAccounts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText ammountOfMoney;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_seaving_accounts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ammountOfMoney = (EditText) findViewById(R.id.editText3);
       // ammountOfMoney.setText(0);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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

        return super.onOptionsItemSelected(item);
    }


    public void onClickAmmount(View view){
        Toast.makeText(this,"Saving bank created",Toast.LENGTH_LONG).show();
        ammountOfMoney.setText("");
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


          //  Intent intentSaving = new Intent(this, CreateSeavingAccounts.class);
          //  startActivity(intentSaving);

        }  else if (id == R.id.nav_home) {


            Intent intentHome = new Intent(this, PersonalPage.class);
            startActivity(intentHome);
        }else if(id == R.id.nav_transfer){

            Intent intentTrans = new Intent(this, TransfertPage.class);
            startActivity(intentTrans);

        }else if(id == R.id.nav_add_money){

            Intent intentAdd = new Intent(this, AddMoneySavingAccount.class);
            startActivity(intentAdd);

        }else if(id == R.id.nav_withdraw_money){

            Intent intentWith = new Intent(this, WithdrawMoneySavingAccount.class);
            startActivity(intentWith);


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
