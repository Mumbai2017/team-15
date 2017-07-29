package trackOrder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.cfg15.R;

import java.util.ArrayList;

/**
 * Created by Admin on 7/29/2017.
 */

public class OrderListAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Order> events;

        public OrderListAdapter(Context context, ArrayList<Order> events) {
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
                row=inflater.inflate(R.layout.event_single_row,parent,false);
                myViewHolder=new MyViewHolder(row);
                row.setTag(myViewHolder);
            }else{
                myViewHolder= (MyViewHolder) row.getTag();

            }
            Order event=events.get(position);
            myViewHolder.text1.setText(event.getId());
            myViewHolder.text2.setText(" "+event.getExpectedDate());
            myViewHolder.text3.setText(" "+event.getTotal());

            return row;
        }
        class MyViewHolder{
            TextView text1;
            TextView text2;
            TextView text3;

            public MyViewHolder(View v) {
                text1= (TextView) v.findViewById(R.id.orderid);
                text2= (TextView) v.findViewById(R.id.date);
                text3= (TextView) v.findViewById(R.id.total);
            }
        }

}
