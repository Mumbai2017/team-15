package com.example.admin.cfg15;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText editTextPassword = (EditText) findViewById(R.id.input_password);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgSelect);
        final Button btnLogin = (Button) findViewById(R.id.btn_login);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbNew = (RadioButton) findViewById(R.id.rbNewUser);
                RadioButton rbExisting = (RadioButton) findViewById(R.id.rbExistingUser);
                if (rbNew.isChecked()) {
                    editTextPassword.setEnabled(false);
                    btnLogin.setText("Sign Up");
                }
                if (rbExisting.isChecked()) {
                    editTextPassword.setEnabled(true);
                    btnLogin.setText("Sign In");

                }
            }
        });

    }

}
