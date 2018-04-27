package com.ayo.pinjam.utils;


import android.util.Log;

/**
 * Created by yanshihao on 2018/1/16.
 */

public class LogUtils {
    private static boolean mBoolean = true;

    public static void logi(String tag, String content) {
        if (mBoolean) {
            Log.i(tag, content);
        }
    }

    public static void logd(String tag, String content) {
        if (mBoolean) {
            Log.d(tag, content);
        }
    }

    public static void loge(String tag, String content) {
        if (mBoolean) {
            Log.e(tag, content);
        }
    }

}
