package com.example.provaaula11042019;

import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.buttonLog);
        final Intent mainPage = new Intent(this, PersonalPage.class);
        final Intent managerPage = new Intent(this, ManagerPage.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText2);
                String content = editText.getText().toString();
                if(content.equals("manager")) {
                    startActivity(managerPage);
                }
                else
                    startActivity(mainPage);
            }
        });
    }
}
