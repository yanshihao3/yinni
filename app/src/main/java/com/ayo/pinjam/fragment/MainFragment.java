package com.ayo.pinjam.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ayo.pinjam.R;
import com.ayo.pinjam.entity.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by yanshihao on 2018/1/2.
 */

public class MainFragment extends BaseFragment {


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    @BindView(R.id.fl_tab_container)
    FrameLayout mFlTabContainer;
    @BindView(R.id.commonTablayout)
    CommonTabLayout mCommonTablayout;
    Unbinder unbinder;


    private SupportFragment[] mFragments = new SupportFragment[2];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {
        ArrayList<CustomTabEntity> tabEntitie = new ArrayList<>();
        CustomTabEntity entity = new TabEntity("Beranda",R.mipmap.ic_home_1, R.mipmap.ic_home);
        tabEntitie.add(entity);
        tabEntitie.add(new TabEntity("Pinjaman",R.mipmap.ic_rank_1, R.mipmap.ic_rank));
        mCommonTablayout.setTabData(tabEntitie);
        mCommonTablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    showHideFragment(mFragments[FIRST], mFragments[SECOND]);
                } else {
                    showHideFragment(mFragments[SECOND], mFragments[FIRST]);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = LoanFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);
        } else {
            // 这里我们需要拿到m    Fragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(LoanFragment.class);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("Main"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("Main");
    }

    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }

    public void startLoginFragment(SupportFragment targetFragment) {
        startWithPop(targetFragment);
    }
}
