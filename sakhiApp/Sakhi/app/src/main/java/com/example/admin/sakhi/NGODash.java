package com.example.admin.sakhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NGODash extends AppCompatActivity {
Intent out,in;
    Button bViewSakhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngodash);
        out=getIntent();
        bViewSakhi=(Button)findViewById(R.id.bViewSakhi);
        bViewSakhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in=new Intent(NGODash.this,Sakhi_details.class);
            }
        });
    }
}
