package com.example.admin.cfg15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        TextView fo= (TextView) findViewById(R.id.tvFinalOrder);
        fo.setText("Amount"+getIntent().getStringExtra("total"));
        ((Button)findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Confirmation.this, Feedback.class);
                startActivity(in);
            }
        });
    }
}
