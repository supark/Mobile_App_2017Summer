package edu.gsu.httpcs.a2017summer.util;

import android.util.Log;

import static android.R.attr.tag;

/**
 * Created by supark on 6/19/17.
 */

public class UtilLog {
    private static boolean isLog = false;

    public static void setIsLog(boolean b) {
        isLog = b;
    }

    public static void d(String tag, String msg) {
        if(isLog){
            Log.d(tag, msg);
        }
    }
    public static void v(String tag, String msg) {
        if(isLog) Log.v(tag,msg);
    }
}
