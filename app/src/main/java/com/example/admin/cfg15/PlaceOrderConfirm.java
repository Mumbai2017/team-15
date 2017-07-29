package com.example.admin.cfg15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaceOrderConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_confirm);
        TextView tv= (TextView) findViewById(R.id.tot);
        tv.setText(getIntent().getStringExtra("total"));
    }
}
