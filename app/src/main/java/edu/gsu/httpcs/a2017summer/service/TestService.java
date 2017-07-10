package edu.gsu.httpcs.a2017summer.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import edu.gsu.httpcs.a2017summer.util.UtilLog;

import static android.R.attr.value;

/**
 * Created by supark on 7/3/17.
 */

public class TestService extends Service {
    private Timer timer = new Timer();
    public int update = 0;
    public static final String UPDATE = "update";
    public static final String ACTION = "testAction";
    public static final String AUDIO = "AUDIO";

    public static final int LOADING = 11111;
    public static final int PLAYING = 22222;
    public static final int PAUSED = 33333;
    public MediaPlayer mediaPlayer = new MediaPlayer();
    public static final int PLAY = 55555;
    public static final int PAUSE = 66666;
    private String url = "";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //timer.schedule(new UpdateTask(), 0, 1000);  //1 second
        if(intent.getAction().equals("AUDIO")) {
            if(intent.getIntExtra("CMD", 0)== PLAY) {
                String urlMsg = intent.getStringExtra("URL");
                if (url.equals(urlMsg)) {
                    mediaPlayer.start();
                    sendPlaying();
                } else {
                    try {
                        url = urlMsg;
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepareAsync();
                        sendLoading();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (intent.getIntExtra("CMD", 0) == PAUSE) {
                mediaPlayer.pause();
                sendPaused();
            }
        }
        else {
            String value = intent.getStringExtra("Service"); //key
            if (value.equals("Start")) {
                timer.schedule(new UpdateTask(), 0, 2000);
            } else if (value.equals("Stop")) {
                timer.cancel();
            }
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                sendPlaying();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendPaused() {
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG", PAUSED);
        sendBroadcast(intent);
    }

    private void sendPlaying() {
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG", PLAYING);
        sendBroadcast(intent);
    }

    private void sendLoading() {
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG", LOADING);
        sendBroadcast(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //only way to communicate between service and activity is broadcast
    //broadcast is heavier than interface so not use any others except service and activity case
    private class UpdateTask extends TimerTask {  //update every second using timer
        public void run() {
            Intent intent = new Intent();
            intent.setAction(ACTION);
            intent.putExtra(UPDATE, ++update);
            sendBroadcast(intent);
            UtilLog.d("Service", update+"");
        }
    }
}