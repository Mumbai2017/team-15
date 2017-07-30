package com.example.admin.cfg15;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.cfg15.R;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedpreferences = getSharedPreferences(Login.MyPREFERENCES, Context.MODE_PRIVATE);
        final String userId=sharedpreferences.getString("userid","NA");
        Log.d("Volley",userId);
        setContentView(R.layout.activity_feedback);
        final String text=((EditText)findViewById(R.id.etFeedback)).getText().toString();
        ((Button)findViewById(R.id.bFeedback)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackApi feedbackApi=new FeedbackApi(getApplicationContext());
                feedbackApi.execute("customer",userId,text);
                Intent in=new Intent(Feedback.this,OrderChoice.class);
                startActivity(in);
            }
        });
    }
}
