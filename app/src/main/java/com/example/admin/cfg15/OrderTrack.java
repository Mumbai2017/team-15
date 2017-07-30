package com.example.admin.cfg15;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import trackOrder.Order;
import trackOrder.OrderListAdapter;

import static com.example.admin.cfg15.Login.MyPREFERENCES;

public class OrderTrack extends AppCompatActivity {

    ListView list;
    public static ArrayList<Order> orderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_track);
        TrackAllApi trackAllApi=new TrackAllApi(getApplicationContext());

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final String userId=sharedpreferences.getString("userid","NA");
        trackAllApi.execute(userId);
        list= (ListView) findViewById(R.id.list);
        OrderListAdapter eventListAdapter=new OrderListAdapter(getApplicationContext(),orderList);
        list.setAdapter(eventListAdapter);


    }
    static void initList(ArrayList<Order> list){
        orderList=list;
    }
}
