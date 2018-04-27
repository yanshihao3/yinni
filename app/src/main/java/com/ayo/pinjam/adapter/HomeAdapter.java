package com.ayo.pinjam.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ayo.pinjam.R;
import com.ayo.pinjam.bean.Product;

import java.util.List;

/**
 * Created by yanshihao on 2018/1/3.
 */

public class HomeAdapter extends BaseQuickAdapter<Product.DataBean, BaseViewHolder> {

    private Context mContext;
    public HomeAdapter(Context context,int layoutResId, @Nullable List<Product.DataBean> data) {
        super(layoutResId, data);
        mContext=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Product.DataBean item) {
        helper.setText(R.id.product_item_tv1,item.getName())
                .setText(R.id.product_item_tv2,item.getProduct_introduction())
                .setText(R.id.product_item_tv4,item.getPassing_rate())
                .setText(R.id.product_item_tv6,item.getMax_algorithm());
        ImageView view = helper.getView(R.id.product_item_iv);
        Glide.with(mContext).load(item.getProduct_logo()).into(view);
    }
}
