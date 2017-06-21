package edu.gsu.httpcs.a2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("Data", "Data");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
