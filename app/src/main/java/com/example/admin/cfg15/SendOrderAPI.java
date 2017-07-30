package com.example.admin.cfg15;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Admin on 7/30/2017.
 */

public class SendOrderAPI extends AsyncTask<String, Void, String> {
    final String InsertURL = "http://192.168.43.186/CFG/register.php";

    Context context;

    public SendOrderAPI(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reply = "";
        try {
            URL insert = new URL(InsertURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) insert.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            Log.d("Volley", "hey");
            OutputStream os = httpURLConnection.getOutputStream();
            Log.d("Volley", "hi hey");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));


            String data = URLEncoder.encode("userId", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8") + "&" +
                    URLEncoder.encode("addr", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                    URLEncoder.encode("total", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8")+ "&" +
                    URLEncoder.encode("return", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            Log.d("Volley", "hey hey");
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "iso-8859-1"));
            String str;

            while ((str = br.readLine()) != null) {
                reply += str;
            }
            Log.d("Volley", reply);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reply;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        Toast.makeText(context, aVoid, Toast.LENGTH_LONG).show();
        if(aVoid.contains("-1")|| aVoid.isEmpty()) Login.user_id=-1;
        else Login.user_id=Integer.parseInt(aVoid);
    }


}
