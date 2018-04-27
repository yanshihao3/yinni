package com.ayo.pinjam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yanshihao on 2017/12/19.
 */

public class NetUtil {
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;
    public static final int NETWORN_MOBILE = 2;
    /**
     * 测试ConnectivityManager
     * ConnectivityManager主要管理和网络连接相关的操作
     * 相关的TelephonyManager则管理和手机、运营商等的相关信息；WifiManager则管理和wifi相关的信息。
     * 想访问网络状态，首先得添加权限<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     * NetworkInfo类包含了对wifi和mobile两种网络模式连接的详细描述,通过其getState()方法获取的State对象则代表着
     * 连接成功与否等状态。
     *
     */
    public static int getNetworkState(Context context) {
        //获取网络链接的服务
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // Wifi的状态
        //CONNECTING 链接, CONNECTED 连接, SUSPENDED暂停, DISCONNECTING 断开, DISCONNECTED 断开, UNKNOWN 未知
        NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORN_WIFI;
        }

        // 3G的状态
        state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORN_MOBILE;
        }
        return NETWORN_NONE;
    }
}
