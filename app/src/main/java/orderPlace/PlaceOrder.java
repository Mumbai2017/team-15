package orderPlace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.cfg15.R;

import java.util.LinkedList;
import java.util.List;

public class PlaceOrder extends AppCompatActivity {


    List<Item> items=new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        items.add(new Item("Breakfast",10,0,0));
        items.add(new Item("dahi bajri methi",10,0,0));
        items.add(new Item("jeera",10,0,0));
        items.add(new Item("khichdi",10,0,0));
        items.add(new Item("nachini",10,0,0));
        items.add(new Item("methi masala",10,0,0));
        items.add(new Item("oats",10,0,0));
    }


}
