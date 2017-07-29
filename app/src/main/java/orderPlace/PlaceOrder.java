package orderPlace;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.cfg15.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlaceOrder extends AppCompatActivity {


    ArrayList<Item> items=new ArrayList<>();
    ListView menu;
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

        menu= (ListView) findViewById(R.id.menuList);

        ItemListAdapter eventListAdapter=new ItemListAdapter(this.getApplicationContext(),items);
        menu.setAdapter(eventListAdapter);
    }
    class ItemListAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Item> events;

        public ItemListAdapter(Context context, ArrayList<Item> events) {
            this.context = context;
            this.events= events;
        }

        @Override
        public int getCount() {
            return events.size();
        }

        @Override
        public Object getItem(int position) {
            return events.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            MyViewHolder myViewHolder=null;
            if(row==null){
                LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=inflater.inflate(R.layout.single_row_order,parent,false);
                myViewHolder=new MyViewHolder(row);
                row.setTag(myViewHolder);
            }else{
                myViewHolder= (MyViewHolder) row.getTag();

            }
            Item event=events.get(position);
            myViewHolder.text1.setText(event.getName());
            myViewHolder.text2.setText(" "+event.getPrice());

            return row;
        }
        class MyViewHolder{

            TextView text1;
            TextView text2;

            public MyViewHolder(View v) {
                text1= (TextView) v.findViewById(R.id.item_name);
                text2= (TextView) v.findViewById(R.id.item_price);

            }
        }
    }


}
