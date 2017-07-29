package com.example.admin.cfg15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Admin on 7/30/2017.
 */

public class OrderChoice extends AppCompatActivity {
    Button bview, vPlaceorder;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_choice);
        Intent out = getIntent();
        bview = (Button) findViewById(R.id.bViewOrder);
        vPlaceorder = (Button) findViewById(R.id.vPlaceOrder);
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(OrderChoice.this, OrderTrack.class);
                startActivity(in);
            }
        });
        vPlaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(OrderChoice.this, placeOrder.class);
                startActivity(in);
            }
        });

    }
}