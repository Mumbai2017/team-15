package com.example.admin.sakhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText etName, etPhn, etAddr, etPass, etTime;
    String name, phn, addr, pass, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etName = (EditText) findViewById(R.id.Username);
        etPhn = (EditText) findViewById(R.id.Phno);
        etAddr = (EditText) findViewById(R.id.Address);
        etPass = (EditText) findViewById(R.id.Password);
        etTime = (EditText) findViewById(R.id.Time);
    }
    public void signUp(View view){
        name = etName.getText().toString();
        phn = etPhn.getText().toString();
        addr = etAddr.getText().toString();
        pass = etPass.getText().toString();
        time = etTime.getText().toString();
        String method = "regSakhi";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(method, name, phn, addr, pass, time);
    }
}
