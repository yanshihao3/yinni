package com.ayo.pinjam.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.ayo.pinjam.R;
import com.ayo.pinjam.utils.SpUtils;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends BaseFragment {

    @BindView(R.id.splash)
    ImageView mSplash;
    Unbinder unbinder;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        // 渐变动画,从完全透明到完全不透明
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        // 持续时间 2秒
        alpha.setDuration(2000);
        // 动画结束后，保持动画状态
        alpha.setFillAfter(true);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean isFrist = SpUtils.getBooleanPreferences(_mActivity, "isFrist", true);
                if (isFrist) {
                    startWithPop(GudeFragment.newInstance());
                } else {
                    boolean isLogin = SpUtils.getBooleanPreferences(_mActivity, "isLogin", false);

                   if (isLogin){
                       startWithPop(MainFragment.newInstance());
                   }else {
                       startWithPop(LoginFragment.newInstance());
                   }
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplash.startAnimation(alpha);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("splash"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("splash");
    }
}
