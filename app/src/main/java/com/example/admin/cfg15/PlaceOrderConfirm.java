package com.example.admin.cfg15;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String MyPREFERENCES = "Data" ;
    public static final String Name = "name";
    public static final String UserID = "userid";
    public static final String Email = "email";
    boolean flag=false;
    public static int user_id=0;
    public static String OI;
    public  SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_confirm);
        tv= (TextView) findViewById(R.id.tot);
        tv.setText(getIntent().getStringExtra("total"));
        total=tv.getText().toString();
        returnStr=getIntent().getStringExtra("ReturnStr");
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final String userId=sharedpreferences.getString("userid","NA");


        // TODO: 7/30/2017 add order int db

        ((Button)findViewById(R.id.confirm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendOrderAPI sendOrderAPI=new SendOrderAPI(getApplicationContext());
                final String addr=((EditText)findViewById(R.id.address)).getText().toString();
                sendOrderAPI.execute(userId,addr,total,returnStr);
                Intent in = new Intent(PlaceOrderConfirm.this, Confirmation.class);
                in.putExtra("total",""+tv.getText().toString());
                in.putExtra("OI",OI);
                startActivity(in);
            }
        });
    }
}
