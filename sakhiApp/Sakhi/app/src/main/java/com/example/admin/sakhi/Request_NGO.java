package com.example.admin.sakhi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.EditText;

public class Request_NGO extends AppCompatActivity {



=======
import android.view.View;
import android.widget.Button;

public class Request_NGO extends AppCompatActivity {
Button place;
>>>>>>> 7b277a0095dbf8be9e01f794bcaeb702af58fa8d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request__ngo);
<<<<<<< HEAD

=======
        Intent out=getIntent();
        place=(Button)findViewById(R.id.con);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(Request_NGO.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Order Placed");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
>>>>>>> 7b277a0095dbf8be9e01f794bcaeb702af58fa8d
    }
}
