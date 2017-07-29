package com.example.admin.cfg15;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class placeOrder extends AppCompatActivity {

    EditText quat1,quat2,quat3,quat4,quat5,quat6,quat7,quat8,quat9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        quat1 = (EditText) findViewById(R.id.quantity1);
        quat2 = (EditText) findViewById(R.id.quantity2);
        quat3 = (EditText) findViewById(R.id.quantity3);
        quat4 = (EditText) findViewById(R.id.quantity4);
        quat5 = (EditText) findViewById(R.id.quantity5);
        quat6 = (EditText) findViewById(R.id.quantity6);
        quat7 = (EditText) findViewById(R.id.quantity7);
        quat8 = (EditText) findViewById(R.id.quantity8);
        quat9 = (EditText) findViewById(R.id.quantity9);


    }
}
