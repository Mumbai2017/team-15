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
import java.util.ArrayList;

import trackOrder.Order;

/**
 * Created by Admin on 7/30/2017.
 */

public class TrackAllApi extends AsyncTask<String, Void, Void>{

        public  ArrayList<Order> list=new ArrayList<>();
        final String InsertURL = "http://192.168.43.186/CFG/get_order.php";

        Context context;

        public TrackAllApi(Context context) {
        this.context = context;
    }

        @Override
        protected void onPreExecute() {
        super.onPreExecute();
    }

        @Override
        protected Void doInBackground(String... params) {
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


            String data =
                    URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            Log.d("Volley", "hey hey");
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "iso-8859-1"));
            String str;

            while ((str = br.readLine()) != null) {
                Log.d("Volley", str);
                String s[]=str.split("=");
                list.add(new Order(Integer.parseInt(s[0]),s[1],Integer.parseInt(s[2])));
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
        protected void onPostExecute(Void aVoid) {
            OrderTrack.initList(list);
    }
}

