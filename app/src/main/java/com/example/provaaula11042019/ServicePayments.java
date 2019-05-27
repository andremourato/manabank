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
import android.widget.EditText;
import android.widget.Toast;

public class ServicePayments extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

     EditText editEntity;
     EditText editReference;
     EditText editAmountBills;

     int waterEntity ;
     int waterRef ;
     int gasEntity ;
     int gasRef ;
     int eleEntity ;
     int eleRef ;

    // int varia  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_payments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editEntity  = (EditText)findViewById(R.id.editText4) ;
        editReference = (EditText)findViewById(R.id.editText5);
        editAmountBills = (EditText)findViewById(R.id.editText6) ;

        final Intent settings = new Intent(this,ServiceBillsSettings.class);

       // varia = 0;


       // Intent intentttt = getIntent();
      //  varia =Integer.getInteger(intentttt.getStringExtra("var"));

      //  if(varia==0){

            waterEntity=59595595;
            waterRef = 544916198;
            gasRef= 232323232;
            gasEntity = 77788888;
            eleEntity = 79494944;
            eleRef = 89898989;


      /*  }else if(varia == 1){

            eleRef= intentttt.getIntExtra("ref",eleRef);
            eleEntity = intentttt.getIntExtra("ent",eleEntity);

        }else if(varia == 2){

            gasRef= intentttt.getIntExtra("ref",gasRef);
            gasEntity = intentttt.getIntExtra("ent",gasEntity);


        }else if(varia == 3){

            waterRef= intentttt.getIntExtra("ref",waterRef);
            waterEntity = intentttt.getIntExtra("ent",waterEntity);

        }
*/
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editEntity.setText(String.valueOf(gasEntity));
                editReference.setText(String.valueOf(gasRef));

            }
        });

        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editEntity.setText(String.valueOf(eleEntity));
                editReference.setText(String.valueOf(eleRef));

            }
        });

        FloatingActionButton fab3 = findViewById(R.id.floatingActionButton3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editEntity.setText(String.valueOf(waterEntity));
                editReference.setText(String.valueOf(waterRef));

            }
        });



        FloatingActionButton fab4 = findViewById(R.id.floatingActionButton4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(settings);

            }
        });

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


    public void onPayBills(View view){
        Toast.makeText(this,"Bills payed ",Toast.LENGTH_LONG).show();
        editAmountBills.setText("");
        editEntity.setText("");
        editReference.setText("");

        Intent intentHome = new Intent(this, PersonalPage.class);
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

         //   Intent intentService = new Intent(this, ServicePayments.class);
         //   startActivity(intentService);

        } else if (id == R.id.nav_create_saving_account) {


            Intent intentSaving = new Intent(this, CreateSeavingAccounts.class);
            startActivity(intentSaving);

        }  else if (id == R.id.nav_home) {


            Intent intentHome = new Intent(this, PersonalPage.class);
            startActivity(intentHome);
        }else if(id == R.id.nav_transfer){

            Intent intentTrans = new Intent(this, TransfertPage.class);
            startActivity(intentTrans);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
