package edu.gsu.httpcs.a2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatchActivity extends AppCompatActivity {


    @BindView(R.id.original_nomail) ImageView original_nomail;
    @BindView(R.id.nomail9) ImageView nomail9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch);
        //ButterKnife.bind(this);
    }
}
