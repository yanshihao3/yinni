package com.ayo.pinjam.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by liuwen on 2016/12/28.
 */
public class ToastUtils {

    private static Toast mToast;

    public static void showToast(Context context, String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();
    }

    public static void showToast(Context context, @StringRes int i) {
        if (mToast == null) {
            mToast = Toast.makeText(context, i, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(i);
        }
        mToast.show();
    }

    public static void removeToast() {
        if (mToast != null) {
            mToast = null;
        }
    }
}
