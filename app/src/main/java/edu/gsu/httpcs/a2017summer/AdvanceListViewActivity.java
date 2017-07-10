package edu.gsu.httpcs.a2017summer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpcs.a2017summer.adapter.AdvanceListViewAdapter;
import edu.gsu.httpcs.a2017summer.adapter.BaseViewPagerAdapter;
import edu.gsu.httpcs.a2017summer.adapter.ViewFragmentStateAdapter;
import edu.gsu.httpcs.a2017summer.fragment.BlueFragment;
import edu.gsu.httpcs.a2017summer.fragment.GreenFragment;
import edu.gsu.httpcs.a2017summer.fragment.RedFragment;

public class AdvanceListViewActivity extends BaseActivity {

    @BindView(R.id.activity_advance_list_view) ListView lv;
    @BindView((R.id.activity_advance_view_quiz4)) ViewPager viewPager;

    private ArrayList<Pair<String, Fragment>> quiz4_list = new ArrayList<Pair<String, Fragment>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello, how are you?");
        list.add("I am fine, thank you!");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");


        quiz4_list.add(new Pair<String, Fragment>("Green", new GreenFragment()));
        quiz4_list.add(new Pair<String, Fragment>("Blue", new BlueFragment()));
        quiz4_list.add(new Pair<String, Fragment>("Red", new RedFragment()));
        ViewFragmentStateAdapter quiz4_adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(), quiz4_list);
        viewPager.setAdapter(quiz4_adapter);

        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this, list);
        //ListView listview = (ListView);
        lv.setAdapter(adapter);
//        getView(0,adapter,)
//        getView().addHeaderView(adapter);

//        TextView tv = new TextView(this);
//        tv.setText("HeaderView");
//        tv.setTextSize(50);
        //lv.addHeaderView(tv);
        //list.add(new RedFragment());
        //lv.add(new RedFragment());

//        listview = (ListView) findViewById(R.id.listview1);
//        listview.setAdapter(adapter);
//
//        // 첫 번째 아이템 추가.
//        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_box_black_36dp),
//                "Box", "Account Box Black 36dp") ;

//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent)
//        {
//            if(convertView == null)
//            {
//                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.book_list_item_arabic, parent, false);
//            }
//
//            TextView txtBookName = (TextView)convertView.findViewById(R.id.txtBookName);
//            txtBookName.setTypeface(arabicFont);
//
//            txtBookName.setText("\"العربية\"");
//            return convertView;
//        }


        TextView tv1 = new TextView(this);
        tv1.setText("FooterView");
        tv1.setTextSize(50);
        lv.addFooterView(tv1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){  //showing position of arraylist when clicking
            @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  //id is related to database
                showToast(String.valueOf(position));  //in order to get item Toast.makeText(getApplication(), "Clicked " + list[position], Toast_LENGTH_SHORT).show();
            }
        });


    }


}
