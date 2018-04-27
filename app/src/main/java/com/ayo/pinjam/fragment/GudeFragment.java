package com.ayo.pinjam.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayo.pinjam.R;
import com.ayo.pinjam.utils.SpUtils;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 */
public class GudeFragment extends BaseFragment {
    BGABanner mBackgroundBanner;


    public static GudeFragment newInstance() {
        return new GudeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gude, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mBackgroundBanner = view.findViewById(R.id.banner_guide_background);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void setListener() {
        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mBackgroundBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                GudeFragment.this.startWithPop(LoginFragment.newInstance());
                SpUtils.setBooleanPreferences(_mActivity,"isFrist",false);
            }
        });
    }

    private void processLogic() {
        // 设置数据源
        mBackgroundBanner.setData(R.mipmap.load_1, R.mipmap.load_2, R.mipmap.load_3);

    }

    @Override
    public void onResume() {
        super.onResume();
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
        setListener();
        processLogic();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}