package edu.gsu.httpcs.a2017summer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.a2017summer.audio.BaseBean;

import static android.R.attr.data;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ActivityA extends BaseActivity {

    @OnClick(R.id.activity_click_A)
    public void toA (View v) {
        goToActivity(ActivityA.class);
    }

    @OnClick(R.id.activity_click_B)
    public void toB (View v) {
        goToActivity(ActivityB.class);
    }

    @OnClick(R.id.activity_click_C)
    public void toC (View v) {
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.activity_click_D)
    public void toD (View v) {
        goToActivity(ActivityD.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("Bundle");
        String bs = bundle.getString("StringBundle");
        int bi = bundle.getInt("IntegerBundle", 0);

        BaseBean bean = (BaseBean) bundle.getSerializable("Object");
        showToast(bean.getName());

        showToast(bs);
        showToast("Integer is : " + bi);

//        String s = intent.getStringExtra("StringInfo");
//        int i = intent.getIntExtra("IntegerInfo", 0);
//        showToast(s);
//        showToast(i + "");  //or String.valueOf(i) <- convert int to string
//        showToast("Integer is : " + i);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }
}
