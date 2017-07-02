package edu.gsu.httpcs.a2017summer;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckBoxActivity extends BaseActivity {

    private HashMap<String, Boolean> list = new HashMap<String, Boolean>();

    @BindView(R.id.activity_check_box_1)
    CheckBox checkBox1;

    @BindView(R.id.activity_check_box_2)
    CheckBox checkBox2;

    @BindView(R.id.activity_check_box_3)
    CheckBox checkBox3;

    @OnClick(R.id.activity_check_box_submit)
    public void submit (View view) {
        String s = "You checked : ";

        for(Map.Entry<String, Boolean> entry: list.entrySet()) {
            if (entry.getValue()) {
                s = s + " " + entry.getKey();
            }
        }
        shortToast(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);  //might be checked more than one so it needs list
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
    }
}
