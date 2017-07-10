package edu.gsu.httpcs.a2017summer.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;

import edu.gsu.httpcs.a2017summer.ServiceActivity;
import edu.gsu.httpcs.a2017summer.TestAudioActivity;
import edu.gsu.httpcs.a2017summer.service.TestService;
import edu.gsu.httpcs.a2017summer.util.UtilLog;

import static edu.gsu.httpcs.a2017summer.service.TestService.UPDATE;

/**
 * Created by supark on 7/5/17.
 */

public class TestAudioController {
    public final static int AudioPlaying = 111;
    public final static int AudioLoading = 222;
    public final static int AudioPaused = 333;

    public static int STATUS = AudioPaused;
    private Context context;
    private TestAudioReceiver testAudioReceiver;
    private AudioListener listener;

    public TestAudioController(Context context, AudioListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void  play(String url) {
        Intent intent = new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("CMD",TestService.PLAY);
        intent.putExtra("URL", url);
        context.startService(intent);
        initReceiver();
    }
    private void initReceiver() {
        testAudioReceiver = new TestAudioReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.AUDIO);  // if you need multiple service, you have to define
        // filter.addAction(***.ACTION);
        context.registerReceiver(testAudioReceiver, filter);  //registerReceiver is belong to activity so need to call
        // context because only activity can have service
    }

    public void pause() {
        Intent intent = new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("CMD",TestService.PAUSE);
        context.startService(intent);
        initReceiver();
    }

    public interface AudioListener {
        public void onPlaying();  //interface only define abstract method(this line)
        public void onLoading();
        public void onPaused();
    }

    public class TestAudioReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(TestService.AUDIO)) {
                int msg = intent.getIntExtra("MSG", 0);
                switch (msg) {
                    case TestService.PLAYING:
                        STATUS = AudioPlaying;
                        UtilLog.d("AUDIO", "Playing");
                        listener.onPlaying();
                        break;

                    case TestService.LOADING:
                        STATUS = AudioLoading;
                        listener.onLoading();
                        UtilLog.d("AUDIO", "Loading");
                        break;

                    case TestService.PAUSED:
                        STATUS = AudioPaused;
                        listener.onPaused();
                        UtilLog.d("AUDIO", "Paused");
                        break;
                }

            }
        }
    }

}
