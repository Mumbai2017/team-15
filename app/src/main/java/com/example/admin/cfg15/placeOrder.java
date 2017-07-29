package com.example.admin.cfg15;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class placeOrder extends AppCompatActivity {

    EditText quat1,quat2,quat3,quat4,quat5,quat6,quat7,quat8,quat9;
    TextView price1,price2,price3,price4,price5,price6,price7,price8,price9;

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
        price1 = (TextView) findViewById(R.id.price1);
        price2 = (TextView) findViewById(R.id.price2);
        price3 = (TextView) findViewById(R.id.price3);
        price4 = (TextView) findViewById(R.id.price4);
        price5 = (TextView) findViewById(R.id.price5);
        price6 = (TextView) findViewById(R.id.price6);
        price7 = (TextView) findViewById(R.id.price7);
        price8 = (TextView) findViewById(R.id.price8);
        price9 = (TextView) findViewById(R.id.price9);

        Button btn = (Button) findViewById(R.id.con);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total=calculateTotal();
                Intent i = new Intent(getApplicationContext(),PlaceOrderConfirm.class);
                i.putExtra("total", ""+total);
                startActivity(i);
            }
        });

    }
    int calculateTotal(){
        int total=0;
        total+=Integer.parseInt(quat1.getText().toString())*Integer.parseInt(price1.getText().toString());
        total+=Integer.parseInt(quat2.getText().toString())*Integer.parseInt(price2.getText().toString());
        total+=Integer.parseInt(quat3.getText().toString())*Integer.parseInt(price3.getText().toString());
        total+=Integer.parseInt(quat4.getText().toString())*Integer.parseInt(price4.getText().toString());
        total+=Integer.parseInt(quat5.getText().toString())*Integer.parseInt(price5.getText().toString());
        total+=Integer.parseInt(quat6.getText().toString())*Integer.parseInt(price6.getText().toString());
        total+=Integer.parseInt(quat7.getText().toString())*Integer.parseInt(price7.getText().toString());
        total+=Integer.parseInt(quat8.getText().toString())*Integer.parseInt(price8.getText().toString());
        total+=Integer.parseInt(quat9.getText().toString())*Integer.parseInt(price9.getText().toString());
        return total;
    }

}
