package edu.gsu.httpcs.a2017summer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gsu.httpcs.a2017summer.fragment.DemoFragment;
import edu.gsu.httpcs.a2017summer.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {


    private TextView tv_demo;
    private TextView tv_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //this is main class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //showing whole contents R.layout.
        initialView();
        setListener();
        //tv_demo.setTextSize();
    }

    private void initialView() {
        tv_demo = (TextView) findViewById(R.id.activity_tool_demo);  // showing demo button R.id.  (TextView) is to convert to TextView
        tv_work = (TextView) findViewById(R.id.actvity_tool_work);  //showing work button   R.id.
    }

    private void setListener() {
        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, demoFragment).commit();

            //assigning an onclicklistener
            tv_demo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    tv_work.setTextColor(Color.BLACK);
                    tv_demo.setTextColor(Color.RED);
                    getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, demoFragment).commit();
                }
            });

            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_work.setTextColor(Color.RED);
                    tv_demo.setTextColor(Color.BLACK);
                    getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, workFragment).commit();
                }

            };

        tv_work.setOnClickListener(listener);
    }

    public void login(View v) {
        Toast.makeText(MainActivity.this, "You clicked login", Toast.LENGTH_SHORT).show();   //easier than above coz can find easily which button
    }
}
