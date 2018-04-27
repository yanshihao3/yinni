package com.ayo.pinjam.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.ayo.pinjam.MyRefreshView;
import com.ayo.pinjam.R;
import com.ayo.pinjam.WrapContentLinearLayoutManager;
import com.ayo.pinjam.adapter.HomeAdapter;
import com.ayo.pinjam.bean.LoginInfo;
import com.ayo.pinjam.bean.Product;
import com.ayo.pinjam.utils.BobyUtils;
import com.ayo.pinjam.utils.HttpClientFactory;
import com.ayo.pinjam.utils.SpUtils;
import com.ayo.pinjam.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.umeng.analytics.MobclickAgent;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.  贷款
 */
public class LoanFragment extends BaseFragment {

    @BindView(R.id.loan_erl)
    EasyRefreshLayout mLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.aiv)
    AVLoadingIndicatorView mIndicatorView;
    Unbinder unbinder;

    private List<Product.DataBean> mList;
    private HomeAdapter mAdapter;

    public static LoanFragment newInstance() {
        return new LoanFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loan, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mList = new ArrayList<>();
        final WrapContentLinearLayoutManager manager = new WrapContentLinearLayoutManager(_mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(manager);
        mAdapter = new HomeAdapter(_mActivity, R.layout.item_layout, mList);
        mRecyclerview.setAdapter(mAdapter);
        mLayout.setLoadMoreModel(LoadModel.NONE);
        mLayout.setRefreshHeadView(new MyRefreshView(getContext()));
        mLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
                initDate();
                mLayout.refreshComplete();
            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("token", SpUtils.getStringPreferences(_mActivity, "token", ""));
                map.put("product_id", mList.get(position).getId());
                map.put("terminal", 1);
                map.put("app_name", 75);
                HttpClientFactory.getSingleton().detail(BobyUtils.getBoby(map))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<LoginInfo>() {
                            @Override
                            public void accept(LoginInfo loginInfo) throws Exception {
                                if (loginInfo.getError_code() == 0) {
                                    ((MainFragment) getParentFragment()).startBrotherFragment(ProductFragment.newInstance(mList.get(position)));

                                } else if (loginInfo.getError_code() == 2) {
                                    ToastUtils.showToast(_mActivity, R.string.login_error_info);
                                    ((MainFragment) getParentFragment()).startLoginFragment(LoginFragment.newInstance());
                                    setLogin(false);
                                } else {
                                    ToastUtils.showToast(_mActivity, loginInfo.getError_message());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtils.showToast(_mActivity, R.string.net_info);
                            }
                        });
            }
        });
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initDate();
    }

    private void initDate() {
        mIndicatorView.show();
        mList.clear();
        mAdapter.notifyDataSetChanged();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "2");
        HttpClientFactory.getSingleton().getProduct(BobyUtils.getBoby(map))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Product>() {
                    @Override
                    public void accept(Product product) throws Exception {
                        if (product.getError_code() == 0) {
                            mList.addAll(product.getData());
                            mAdapter.notifyDataSetChanged();
                            mIndicatorView.hide();
                        } else {
                            ToastUtils.showToast(_mActivity, product.getError_message());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showToast(_mActivity, R.string.error_net);

                    }
                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("loan"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("loan");
    }
}
