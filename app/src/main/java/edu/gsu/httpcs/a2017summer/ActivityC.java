package edu.gsu.httpcs.a2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityC extends BaseActivity {

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
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);
        showToast("onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }
}
