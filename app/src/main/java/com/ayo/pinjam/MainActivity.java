package com.ayo.pinjam;

import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;
import com.ayo.pinjam.fragment.SplashFragment;
import com.ayo.pinjam.receiver.NetReceiver;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends SupportActivity {

    NetReceiver receiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new NetReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");  //添加要收到的广播
        registerReceiver(receiver, filter);

        if (findFragment(SplashFragment.class) == null) {
            loadRootFragment(R.id.fl_container, SplashFragment.newInstance());
        }
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}