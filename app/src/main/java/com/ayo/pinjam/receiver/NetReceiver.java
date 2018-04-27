package com.ayo.pinjam.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ayo.pinjam.R;
import com.ayo.pinjam.utils.NetUtil;
import com.ayo.pinjam.utils.ToastUtils;


public class NetReceiver extends BroadcastReceiver {

    private static String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(NET_CHANGE_ACTION)) {
            if (NetUtil.getNetworkState(context) == NetUtil.NETWORN_NONE) {
                ToastUtils.showToast(context, R.string.net_info);
            }
        }

    }
}

