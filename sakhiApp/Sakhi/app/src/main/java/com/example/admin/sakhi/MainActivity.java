package com.example.admin.sakhi;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
RadioGroup type;
    EditText username,password;
    Button btn_login;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.input_email);
        password=(EditText)findViewById(R.id.input_password);
        type=(RadioGroup)findViewById(R.id.rgSelect);
        btn_login=(Button)findViewById(R.id.btn_login);
        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton new_user=(RadioButton)findViewById(R.id.rbNewUser);
                RadioButton ngo=(RadioButton)findViewById(R.id.rbNGO);
                RadioButton existing=(RadioButton)findViewById(R.id.rbExistingUser);
                if(existing.isChecked())
                {
                    username.setEnabled(true);
                    password.setEnabled(true);
                    btn_login.setText("Sign in");
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            in=new Intent(MainActivity.this,StatusSakhi.class);
                            startActivity(in);
                        }
                    });

                }
                if(new_user.isChecked())
                {
                    username.setEnabled(true);
                    password.setEnabled(false);
                    btn_login.setText("Sign up");
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            in=new Intent(MainActivity.this,Registration.class);
                            startActivity(in);
                        }
                    });

                }
                if(ngo.isChecked())
                {
                    username.setEnabled(true);
                    password.setEnabled(true);
                    btn_login.setText("Sign in");
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            in=new Intent(MainActivity.this,NGODash.class);
                            startActivity(in);
                        }
                    });

                }
            }
        });
    }
}
