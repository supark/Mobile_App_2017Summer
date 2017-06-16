package edu.gsu.httpcs.a2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchModeActivity extends AppCompatActivity {

    @OnClick(R.id.test)
    public void click(View v) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        //Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
    }
}
