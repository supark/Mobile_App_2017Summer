package edu.gsu.httpcs.a2017summer.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.gsu.httpcs.a2017summer.R;
import edu.gsu.httpcs.a2017summer.util.UtilDensity;

import static edu.gsu.httpcs.a2017summer.R.drawable.chatfrom_bg_focused;

/**
 * Created by supark on 6/14/17.
 */

public class AdvanceListViewAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<String> list;
    private final LayoutInflater inflater;

    public AdvanceListViewAdapter(Context context, ArrayList<String> list) {  //adapter construct needs two parameters
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  //convert inflate - 1
    }
    //Below from getCount() to View getView(~~) are required because listview always ask to adapter get information.
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }  //return list[position];

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("ViewHolder", "getView");
        ViewHolder viewHolder;

        if(convertView == null) {
            Log.d("ViewHolder", "getViewById");
            convertView = inflater.inflate(R.layout.activity_advance_list_item, parent, false); //convert inflate - 2
            viewHolder = new ViewHolder();
            viewHolder.rl_odd = (RelativeLayout)convertView.findViewById(R.id.odd);
            viewHolder.rl_even = (RelativeLayout)convertView.findViewById(R.id.even);
            viewHolder.tv = (TextView)convertView.findViewById(R.id.activity_advance_list_item_tv);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.tv.setText(list.get(position));
        viewHolder.lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);


        if(position%2 == 0){
            //message from you
            viewHolder.rl_odd.setVisibility(View.INVISIBLE);
            viewHolder.rl_even.setVisibility(View.VISIBLE);
            viewHolder.tv.setBackgroundResource(R.drawable.chatto_bg_focused);
            viewHolder.lp.setMargins(0,0, UtilDensity.dip2px(context, 70),0);  //55(picture size) + 10(border) + 5(margin)
            viewHolder.lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            viewHolder.tv.setLayoutParams(viewHolder.lp);
        }
        else {
            //message from your friends
            viewHolder.rl_odd.setVisibility(View.VISIBLE);
            viewHolder.rl_even.setVisibility(View.INVISIBLE);
            viewHolder.tv.setBackgroundResource(R.drawable.chatfrom_bg_focused);
            viewHolder.lp.setMargins(UtilDensity.dip2px(context, 70),0,0,0);
            viewHolder.lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            viewHolder.tv.setLayoutParams(viewHolder.lp);
        }
        return convertView;
    }

    private class ViewHolder{  //to control memory storage to not occupy all cf)recycle view
        RelativeLayout rl_odd;
        RelativeLayout rl_even;
        TextView tv;
        RelativeLayout.LayoutParams lp;
    }
}
