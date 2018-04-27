package com.ayo.pinjam.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ayo.pinjam.R;
import com.ayo.pinjam.utils.LogUtils;
import com.ayo.pinjam.utils.ToastUtils;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HtmlFragment extends SupportFragment {


    @BindView(R.id.bar)
    ProgressBar mBar;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.html_title)
    TextView mTitle;
    private String html;

    Unbinder unbinder;

    public static HtmlFragment newInstance(String url, String title) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", title);
        HtmlFragment htmlFragment = new HtmlFragment();
        htmlFragment.setArguments(bundle);
        return htmlFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_html, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        html = getArguments().getString("url");
        String title = getArguments().getString("title");
        mTitle.setText(title);
        getDate();
    }

    private void getDate() {

        if (html != null) {
            mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
            mWebView.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
            mWebView.getSettings().setSupportZoom(true);//是否可以缩放，默认true
            mWebView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
            mWebView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
            mWebView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
            mWebView.getSettings().setAppCacheEnabled(true);//是否使用缓存
            mWebView.getSettings().setDomStorageEnabled(true);//DOM Storage
            // displayWebview.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
            mWebView.loadUrl(html);
            if (Build.VERSION.SDK_INT >= 21) {
                mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }

            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {

                    LogUtils.loge("url", url);
                    if (url.startsWith("http:") || url.startsWith("https:")) {
                        if (url.contains("https://play.google.com/store/apps/")) {
                            try {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setPackage("com.android.vending");
                                intent.setData(Uri.parse(url));
                                pop();
                                startActivity(intent);
                            } catch (Exception e) {
                                ToastUtils.showToast(_mActivity, R.string.google);
                            }
                        } else {
                            view.loadUrl(url);
                        }
                        return true;
                    }
                    if (url.startsWith("market:")) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setPackage("com.android.vending");
                            intent.setData(Uri.parse(url));
                            pop();
                            startActivity(intent);
                        } catch (Exception e) {
                            ToastUtils.showToast(_mActivity, R.string.google);
                        }
                        return true;
                    }
                    if (url.startsWith("app:")) {
                        try {
                            // 以下固定写法
                            final Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(url));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                        } catch (Exception e) {
                            // 防止没有安装的情况
                            e.printStackTrace();
                        }
                        return true;
                    }

                    return false;
                }
            });


            mWebView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (keyEvent.getAction() == keyEvent.ACTION_DOWN) {

                        if (i == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                            mWebView.goBack();
                            return true;
                        }
                    }
                    return false;
                }
            });

            mWebView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    // TODO 自动生成的方法存根
                    if (mBar != null) {
                        if (newProgress == 100) {
                            mBar.setVisibility(View.GONE);//加载完网页进度条消失
                        } else {
                            mBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                            mBar.setProgress(newProgress);//设置进度值
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mWebView.destroy();
        unbinder.unbind();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("Html"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("html");
    }
}
