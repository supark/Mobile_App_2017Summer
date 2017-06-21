package edu.gsu.httpcs.a2017summer;

import android.app.Application;
import android.util.Log;

import edu.gsu.httpcs.a2017summer.util.UtilLog;

/**
 * Created by supark on 6/19/17.
 */

public class suApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }

}
