package com.example.admin.cfg15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlaceOrderConfirm extends AppCompatActivity {

    TextView tv;
    String returnStr;
    String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_confirm);
        tv= (TextView) findViewById(R.id.tot);
        tv.setText(getIntent().getStringExtra("total"));
        total=tv.getText().toString();
        returnStr=getIntent().getStringExtra("ReturnStr");
        final String userId=Login.sharedpreferences.getString("userid","NA");


        // TODO: 7/30/2017 add order int db

        ((Button)findViewById(R.id.confirm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendOrderAPI sendOrderAPI=new SendOrderAPI(getApplicationContext());
                final String addr=((EditText)findViewById(R.id.address)).getText().toString();
                sendOrderAPI.execute(userId,addr,total,returnStr);
                Intent in = new Intent(PlaceOrderConfirm.this, Confirmation.class);
                in.putExtra("total",""+tv.getText().toString());
                startActivity(in);
            }
        });
    }
}
