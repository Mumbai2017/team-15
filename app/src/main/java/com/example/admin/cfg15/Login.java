package com.example.admin.cfg15;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Login extends AppCompatActivity {

    public static final String MyPREFERENCES = "Data" ;
    public static final String Name = "name";
    public static final String UserID = "userid";
    public static final String Email = "email";
    boolean flag=false;
    public static int user_id=0;
    public static SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String userName=sharedpreferences.getString(UserID,"NA");
        if(!userName.equals("NA")){
            Intent in=new Intent(Login.this,OrderChoice.class);
            startActivity(in);
        }
        final EditText editTextPassword = (EditText) findViewById(R.id.input_password);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgSelect);
        final Button btnLogin = (Button) findViewById(R.id.btn_login);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbNew = (RadioButton) findViewById(R.id.rbNewUser);
                RadioButton rbExisting = (RadioButton) findViewById(R.id.rbExistingUser);
                if (rbNew.isChecked()) {
                    //editTextPassword.setEnabled(false);
                    btnLogin.setText("Sign Up");
                    flag=false;
                }
                if (rbExisting.isChecked()) {
                    //editTextPassword.setEnabled(true);
                    flag=true;
                    btnLogin.setText("Sign In");

                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email= (EditText) findViewById(R.id.input_email);
                EditText pass= (EditText) findViewById(R.id.input_password);

                if(!flag){
                    RegistrationApi registrationApi=new RegistrationApi(getApplicationContext());
                    registrationApi.execute(email.getText().toString(),pass.getText().toString());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(user_id!=-1 ){
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        Log.d("Volley",""+user_id);
                        editor.putString(Name, ""); // TODO: 7/30/2017 add name here
                        editor.putString(UserID, ""+user_id);
                        editor.putString(Email, email.getText().toString());
                        editor.commit();

                        Intent in=new Intent(Login.this,OrderChoice.class);
                        startActivity(in);
                    }
                }else{
                    LoginApi api=new LoginApi(getApplicationContext());
                    api.execute(email.getText().toString(),pass.getText().toString());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(user_id!=-1){
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        Log.d("Volley",""+user_id);
                        editor.putString(Name, ""); // TODO: 7/30/2017 add name here
                        editor.putString(UserID, ""+user_id);
                        editor.putString(Email, email.getText().toString());
                        editor.commit();

                        Intent in=new Intent(Login.this,OrderChoice.class);
                        startActivity(in);
                    }
                }
            }
        });

    }

}
