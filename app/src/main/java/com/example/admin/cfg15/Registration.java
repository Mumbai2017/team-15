package com.example.admin.cfg15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText email= (EditText) findViewById(R.id.input_email);
        EditText pass= (EditText) findViewById(R.id.input_password);
        RegistrationApi registrationApi=new RegistrationApi(getApplicationContext());
        registrationApi.execute(email.getText().toString(),pass.getText().toString());

    }
}
