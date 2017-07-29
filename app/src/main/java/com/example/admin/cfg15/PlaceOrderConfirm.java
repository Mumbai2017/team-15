package com.example.admin.cfg15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlaceOrderConfirm extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_confirm);
        tv= (TextView) findViewById(R.id.tot);
        tv.setText(getIntent().getStringExtra("total"));

        // TODO: 7/30/2017 add order int db

        ((Button)findViewById(R.id.confirm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(PlaceOrderConfirm.this, Confirmation.class);
                in.putExtra("total",""+tv.getText().toString());
                startActivity(in);
            }
        });
    }
}
