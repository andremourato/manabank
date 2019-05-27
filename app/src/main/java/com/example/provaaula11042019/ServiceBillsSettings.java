package com.example.provaaula11042019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceBillsSettings extends AppCompatActivity {

    private EditText editRef;
    private EditText editEnt;

    private int var ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_bills_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editRef = (EditText)findViewById(R.id.editText13);
        editEnt = (EditText)findViewById(R.id.editText15);



        var = 0;
        FloatingActionButton fab = findViewById(R.id.floatingActionButton6);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var = 1;

            }
        });

        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton7);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var = 2;

            }
        });

        FloatingActionButton fab3 = findViewById(R.id.floatingActionButton8);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var = 3;

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void onModBills(View view){

        String value = editRef.getText().toString();
        String value2 = editEnt.getText().toString();

        int refValue =Integer.parseInt(value);
        int entityValue =Integer.parseInt(value2);



        Intent intentServicePay = new Intent(this, ServicePayments.class);

        if(var == 1){
            intentServicePay.putExtra("tagg", var);

        }else if(var == 2){
            intentServicePay.putExtra("tagg", var);
        }else if( var == 3){
            intentServicePay.putExtra("tagg", var);
        }else if(var == 0){
            intentServicePay.putExtra("tagg", var);
        }

        intentServicePay.putExtra("ref",refValue);
        intentServicePay.putExtra("ent",entityValue);
        startActivity(intentServicePay);

    }


}


