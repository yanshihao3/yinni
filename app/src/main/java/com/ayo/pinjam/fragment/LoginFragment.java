package com.ayo.pinjam.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ayo.pinjam.R;
import com.ayo.pinjam.bean.LoginInfo;
import com.ayo.pinjam.utils.BobyUtils;
import com.ayo.pinjam.utils.CaptchaTimeCount;
import com.ayo.pinjam.utils.CodeUtils;
import com.ayo.pinjam.utils.HttpClientFactory;
import com.ayo.pinjam.utils.LogUtils;
import com.ayo.pinjam.utils.SpUtils;
import com.ayo.pinjam.utils.ToastUtils;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {


    @BindView(R.id.iv_phone)
    ImageView mIvPhone;
    Unbinder unbinder;
    @BindView(R.id.login_phone)
    EditText mPhone;
    @BindView(R.id.login_code)
    EditText mImageCode;
    @BindView(R.id.login_iv)
    ImageView mImage;
    @BindView(R.id.login_phone_code)
    EditText mPhoneCode;
    @BindView(R.id.getCode)
    Button mGetBtn;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.rl_code)
    RelativeLayout mLayout;

    private CodeUtils mCodeUtils;
    private Bitmap mBitmap;
    private String mCode;

    private CaptchaTimeCount mTimeCount;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mCodeUtils = CodeUtils.getInstance();
        mBitmap = mCodeUtils.createBitmap();
        mCode = mCodeUtils.getCode();
        mImage.setImageBitmap(mBitmap);
        mTimeCount = new CaptchaTimeCount(60000, 1000
                , mGetBtn, _mActivity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_iv, R.id.getCode, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_iv:
                mBitmap = mCodeUtils.createBitmap();
                mCode = mCodeUtils.getCode();
                mImage.setImageBitmap(mBitmap);
                break;
            case R.id.getCode:
                getCode();
                break;
            case R.id.login_btn:
                login();
                break;
        }
    }

    private boolean pattern(String str) {
        String pattern = "^[0][8]\\d{7,10}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }


    private void login() {
        String phone = mPhone.getText().toString();
        String code = mImageCode.getText().toString();
        if (phone.isEmpty()) {
            ToastUtils.showToast(_mActivity, R.string.enter_phone);
            return;
        }
        if (!pattern(phone)) {
            ToastUtils.showToast(_mActivity, R.string.enter_ok_phone);
            return;
        }
        if (code.isEmpty()) {
            ToastUtils.showToast(_mActivity, R.string.enter_code);
            return;
        }
        if (!mCode.equals(code)) {
            ToastUtils.showToast(_mActivity, R.string.enter_ok_coe);
            return;
        }
        if (mLayout.getVisibility() == View.GONE) {

            HashMap<String, Object> map = new HashMap<>();
            map.put("userphone", phone);
            map.put("terminal", 1);
            map.put("app_name", 75);
            RequestBody boby = BobyUtils.getBoby(map);
            HttpClientFactory.getSingleton().getCode(boby)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<LoginInfo>() {
                        @Override
                        public void accept(LoginInfo loginInfo) throws Exception {
                            LogUtils.loge("login", loginInfo.toString());
                            int code = loginInfo.getError_code();
                            if (code == 0) {
                                int is_user = loginInfo.getData().getIs_user();
                                if (is_user == 0) { //老用户
                                    startWithPop(MainFragment.newInstance());
                                    SpUtils.setStringPreferences(_mActivity,
                                            "token", loginInfo.getData().getToken());
                                    SpUtils.setBooleanPreferences(_mActivity
                                            , "isLogin", true);

                                } else {//新用户
                                    mLayout.setVisibility(View.VISIBLE);
                                    mTimeCount.start();
                                }
                            } else {
                                ToastUtils.showToast(_mActivity, loginInfo.getError_message());
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            LogUtils.loge("login", throwable.toString());
                            ToastUtils.showToast(_mActivity, R.string.error_net);
                        }
                    });
            return;
        }
        if (mLayout.getVisibility() == View.VISIBLE) {
            String phonecode = mPhoneCode.getText().toString();
            if (phonecode.isEmpty()) {
                ToastUtils.showToast(_mActivity, R.string.enter_code);
            } else {
                HashMap<String, Object> map = new HashMap<>();
                map.put("userphone", phone);
                map.put("code", mPhoneCode.getText().toString());
                RequestBody boby = BobyUtils.getBoby(map);
                HttpClientFactory.getSingleton().login(boby)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<LoginInfo>() {
                            @Override
                            public void accept(LoginInfo loginInfo) throws Exception {
                                LogUtils.loge("login", loginInfo.toString());
                                if (loginInfo.getError_code() == 0) {
                                    startWithPop(MainFragment.newInstance());
                                    SpUtils.setStringPreferences(_mActivity,
                                            "token", loginInfo.getData().getToken());
                                    SpUtils.setBooleanPreferences(_mActivity
                                            , "isLogin", true);
                                } else {
                                    ToastUtils.showToast(_mActivity, loginInfo.getError_message());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                LogUtils.loge("login", throwable.toString());
                                ToastUtils.showToast(_mActivity, R.string.error_net);
                            }
                        });
            }
            return;
        }
    }

    public void getCode() {

        String phone = mPhone.getText().toString();
        String code = mImageCode.getText().toString();
        if (phone.isEmpty()) {
            ToastUtils.showToast(_mActivity, R.string.enter_phone);
            return;
        }
        if (!pattern(phone)) {
            ToastUtils.showToast(_mActivity, R.string.enter_ok_phone);
            return;
        }
        if (code.isEmpty()) {
            ToastUtils.showToast(_mActivity, R.string.enter_code);
            return;
        }
        if (!mCode.equals(code)) {
            ToastUtils.showToast(_mActivity, R.string.enter_ok_coe);
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("userphone", phone);
        map.put("terminal", 1);
        map.put("app_name",75);
        RequestBody boby = BobyUtils.getBoby(map);
        HttpClientFactory.getSingleton().getCode(boby)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginInfo>() {
                    @Override
                    public void accept(LoginInfo loginInfo) throws Exception {
                        LogUtils.loge("login", loginInfo.toString());
                        int code = loginInfo.getError_code();
                        if (code == 0) {
                            mTimeCount.start();

                        } else {
                            ToastUtils.showToast(_mActivity, loginInfo.getError_message());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.loge("login", throwable.toString());
                        ToastUtils.showToast(_mActivity, R.string.error_net);
                    }
                });
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("login"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("login");
    }
}
