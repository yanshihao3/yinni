package com.ayo.pinjam.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ayo.pinjam.MyRefreshView;
import com.ayo.pinjam.R;
import com.ayo.pinjam.WrapContentLinearLayoutManager;
import com.ayo.pinjam.adapter.HomeAdapter;
import com.ayo.pinjam.bean.ImageUrl;
import com.ayo.pinjam.bean.LoginInfo;
import com.ayo.pinjam.bean.Product;
import com.ayo.pinjam.onekeyshare.OnekeyShare;
import com.ayo.pinjam.utils.BobyUtils;
import com.ayo.pinjam.utils.HttpClientFactory;
import com.ayo.pinjam.utils.LogUtils;
import com.ayo.pinjam.utils.SpUtils;
import com.ayo.pinjam.utils.ToastUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.umeng.analytics.MobclickAgent;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_title)
    TextView mHomeTitle;
    @BindView(R.id.home_recyclerview)
    RecyclerView mHomeRecyclerview;
    @BindView(R.id.erl)
    EasyRefreshLayout mRefresh;
    Unbinder unbinder;
    @BindView(R.id.aiv)
    AVLoadingIndicatorView mIndicatorView;
    @BindView(R.id.adView)
    AdView mAdView;

    private HomeAdapter mAdapter;
    private List<Product.DataBean> mList;
    private BGABanner mBanner;
    private ArrayList<String> mUrl;
    private List<ImageUrl.DataBean> mData;
    private ArrayList<String> mTitle;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    private String TAG="adview";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        MobileAds.initialize(_mActivity,
                "ca-app-pub-4931903441608047~4910824487");
        loadAd();
        setListener();
        initData();
        return view;
    }

    private void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        if (mAdView!=null) {
            mAdView.loadAd(adRequest);
        }
    }

    private void setListener(){
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                Log.e(TAG, "onAdLoaded: " );            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.e(TAG, "onAdFailedToLoad: " );
                loadAd();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e(TAG, "onAdOpened: " );
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.e(TAG, "onAdLeftApplication: " );
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.e(TAG, "onAdClosed: ");
                mAdView.setVisibility(View.GONE);
            }

            @Override
            public void onAdClicked() {
                Log.e(TAG, "onAdClicked: ");
            }
        });
    }

    private void initData() {
        mIndicatorView.show();
        mData.clear();
        mAdapter.notifyDataSetChanged();
        mUrl.clear();
        mList.clear();
        HttpClientFactory.getSingleton().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ImageUrl>() {
                    @Override
                    public void accept(ImageUrl imageUrl) throws Exception {
                        if (imageUrl.getError_code() == 0) {
                            mData.addAll(imageUrl.getData());
                            for (int i = 0; i < mData.size(); i++) {
                                mUrl.add(mData.get(i).getPictrue());
                                // mTitle.add(mData.get(i).getName());
                            }
                            initBanner();
                        } else {
                            ToastUtils.showToast(_mActivity, imageUrl.getError_message());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "1");
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

    private void initBanner() {
        mBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @SuppressLint("CheckResult")
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                RequestOptions options = new RequestOptions();
                options.diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .placeholder(R.mipmap.load_banner)
                ;
                Glide.with(_mActivity)
                        .load(model)
                        .apply(options)
                        .into(itemView);

            }
        });
        mBanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {

                String html = mData.get(position).getH5();
                if (html.contains("https://play.google.com/store/apps/")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.android.vending");
                    intent.setData(Uri.parse(html));
                    startActivity(intent);
                } else {
                    ((MainFragment) getParentFragment()).startBrotherFragment(HtmlFragment.newInstance(mData.get(position).getH5()
                            , mData.get(position).getName()));
                }
            }
        });
        mBanner.setData(mUrl, null);
    }

    private void initView() {
        mList = new ArrayList<>();
        final WrapContentLinearLayoutManager manager = new WrapContentLinearLayoutManager(_mActivity, LinearLayoutManager.VERTICAL, false);
        mHomeRecyclerview.setLayoutManager(manager);
        mAdapter = new HomeAdapter(_mActivity, R.layout.item_layout, mList);
        mHomeRecyclerview.setAdapter(mAdapter);
        View view = View.inflate(_mActivity, R.layout.head_layout, null);
        mBanner = view.findViewById(R.id.head_banner);
        mAdapter.setHeaderView(view);
        mData = new ArrayList<>();
        mUrl = new ArrayList<>();
        mTitle = new ArrayList<>();
        mRefresh.setLoadMoreModel(LoadModel.NONE);

        mRefresh.setRefreshHeadView(new MyRefreshView(getContext()));
        mRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
                initData();
                mRefresh.refreshComplete();
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("home"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("home");
    }

    //分享
    @OnClick(R.id.share)
    public void onViewClicked() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // text是分享文本，所有平台都需要这个字段
        LogUtils.loge("share url", "https://play.google.com/store/apps/details?id=" + _mActivity.getPackageName());
        oks.setUrl("https://play.google.com/store/apps/details?id=" + _mActivity.getPackageName());
        // 启动分享GUI
        oks.show(getContext());
    }
}
