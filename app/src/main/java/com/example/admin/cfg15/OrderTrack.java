package com.example.admin.cfg15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import trackOrder.Order;
import trackOrder.OrderListAdapter;

public class OrderTrack extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_track);

        list= (ListView) findViewById(R.id.list);
        ArrayList<Order> orderList=new ArrayList<>();
        orderList.add(new Order(1,"2121",10));
        orderList.add(new Order(2,"2521",10));
        orderList.add(new Order(3,"2421",10));
        orderList.add(new Order(4,"2321",10));
        orderList.add(new Order(5,"2221",10));

        OrderListAdapter eventListAdapter=new OrderListAdapter(getApplicationContext(),orderList);
        list.setAdapter(eventListAdapter);
    }
}
