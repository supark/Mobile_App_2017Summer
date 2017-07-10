package edu.gsu.httpcs.a2017summer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.a2017summer.service.TestService;
import edu.gsu.httpcs.a2017summer.util.UtilLog;

import static android.bluetooth.BluetoothClass.Service.AUDIO;

import static edu.gsu.httpcs.a2017summer.service.TestService.UPDATE;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.activity_service_tv)
    TextView textView;

    private TestReceiver testReceiver;

    @OnClick(R.id.activity_service_start)
    public void startService (View v) {
        Intent intent = new Intent(this, TestService.class);
        intent.putExtra("Service", "Start"); //carry some message  key-value
        startService(intent);
        registerBrocast();  //selecting the who is got the broadcast
    }

    @OnClick(R.id.activity_service_stop)
    public void stopService(View v) {
        Intent intent = new Intent(this, TestService.class);
        intent.putExtra("Service", "Stop"); //carry some message  key-value
        startService(intent);

    }

    private void registerBrocast() {

        testReceiver = new TestReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.ACTION);  // if you need multiple service, you have to define
        // filter.addAction(***.ACTION);
        registerReceiver(testReceiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

    }

    public class TestReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(TestService.ACTION)) {
                int update = intent.getIntExtra(UPDATE, 0);
                textView.setText(String.valueOf(update));


            }
        }
    }


}
