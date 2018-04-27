package com.ayo.pinjam.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayo.pinjam.R;
import com.ayo.pinjam.bean.LoginInfo;
import com.ayo.pinjam.bean.Product;
import com.ayo.pinjam.utils.BobyUtils;
import com.ayo.pinjam.utils.HttpClientFactory;
import com.ayo.pinjam.utils.SpUtils;
import com.ayo.pinjam.utils.ToastUtils;
import com.bumptech.glide.Glide;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author yanshihao.
 * @date on 2017/10/23.
 * @email 15732052465@163.com
 */

public class ProductFragment extends SupportFragment {

    Unbinder unbinder;
    @BindView(R.id.title_name)
    TextView mTitleName;
    @BindView(R.id.product_iv_logo)
    ImageView mProductIvLogo;
    @BindView(R.id.product_tv_name)
    TextView mProductTvName;
    @BindView(R.id.product_tv_money)
    TextView mProductTvMoney;
    @BindView(R.id.product_tv_limit)
    TextView mProductTvLimit;
    @BindView(R.id.product_tv_speed)
    TextView mProductTvSpeed;
    @BindView(R.id.product_tv_succes)
    TextView mProductTvSucces;
    @BindView(R.id.product_tv_request)
    TextView mProductTvRequest;
    private Product.DataBean mProduct;


    public static ProductFragment newInstance(Product.DataBean product) {
        Bundle args = new Bundle();
        args.putParcelable("Product", product);
        ProductFragment fragment = new ProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        unbinder = ButterKnife.bind(this, view);
        getData();
        setViews();
        return view;
    }

    private void setViews() {
        mTitleName.setText(mProduct.getName());
        mProductTvName.setText(mProduct.getName());
        mProductTvMoney.setText("Kuota peminjaman : " + mProduct.getMaximum_amount());
        mProductTvLimit.setText("Batas peminjaman : " + mProduct.getMax_cycle());
        mProductTvSpeed.setText("Waktu mendapat peminjaman :" + mProduct.getFastest());
        mProductTvSucces.setText("Lulus :" + mProduct.getPassing_rate());
        mProductTvRequest.setText(mProduct.getProduct_details());
        Glide.with(_mActivity).load(mProduct.getProduct_logo()).into(mProductIvLogo);

    }

    private void getData() {
        mProduct = (Product.DataBean) getArguments().getParcelable("Product");
    }

    @OnClick(R.id.btn_product_details_apply)
    public void onClick() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", SpUtils.getStringPreferences(_mActivity, "token", ""));
        map.put("product_id", mProduct.getId());
        map.put("terminal", 1);
        map.put("app_name", 75);
        HttpClientFactory.getSingleton().apply(BobyUtils.getBoby(map))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginInfo>() {

                    @Override
                    public void accept(LoginInfo loginInfo) throws Exception {
                        if (loginInfo.getError_code() == 2) {
                            ToastUtils.showToast(_mActivity, R.string.login_error_info);

                            startWithPop(LoginFragment.newInstance());

                            setLogin(false);
                        } else if (loginInfo.getError_code() == 0) {
                            String html = mProduct.getLink();
                            if (html.contains("https://play.google.com/store/apps/")) {
                                try {
                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                    intent.setPackage("com.android.vending");
                                    intent.setData(Uri.parse(html));
                                    pop();
                                    startActivity(intent);
                                } catch (Exception e) {
                                    ToastUtils.showToast(_mActivity, R.string.google);
                                }
                            } else {
                                startWithPop(HtmlFragment.newInstance(mProduct.getLink(), mProduct.getName()));
                            }

                        } else {
                            ToastUtils.showToast(_mActivity, loginInfo.getError_message());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showToast(_mActivity,R.string.net_info);
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
        MobclickAgent.onPageStart("product"); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("product");
    }

    private void setLogin(boolean b){
        SpUtils.setBooleanPreferences(_mActivity,"isLogin",b);
    }
}
