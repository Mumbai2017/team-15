package com.example.admin.sakhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class StatusSakhi extends AppCompatActivity {
ToggleButton toggleButtonStatus;
    Button bCheckOrder,bReq,bfeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_sakhi);
        Intent out=getIntent();
        bCheckOrder=(Button)findViewById(R.id.bCheckOrder);
        bReq=(Button)findViewById(R.id.bRequestFromNGO);
        bfeed=(Button)findViewById(R.id.bFeedback);
        toggleButtonStatus=(ToggleButton)findViewById(R.id.toggleButtonStatus);
        toggleButtonStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                bCheckOrder.setEnabled(true);
                else
                    bCheckOrder.setEnabled(false);
            }
        });
        bReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(StatusSakhi.this,Request_NGO.class);
                startActivity(a);
            }
        });
        bfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(StatusSakhi.this,Feedback.class);
                startActivity(a);
            }
        });
        if(bCheckOrder.isEnabled())
        {
            bCheckOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a=new Intent(StatusSakhi.this,Orders.class);
                }
            });
        }
    }
}
