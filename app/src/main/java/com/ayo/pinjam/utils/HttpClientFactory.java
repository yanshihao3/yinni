package com.ayo.pinjam.utils;


import com.ayo.pinjam.bean.ImageUrl;
import com.ayo.pinjam.bean.LoginInfo;
import com.ayo.pinjam.bean.Product;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by yanshihao on 2017/12/12.
 */

public class HttpClientFactory {

    private static class Holder {
        private static HttpClient singleton = newIntance();
    }

    public static HttpClient getSingleton() {
        return Holder.singleton;
    }

    private static String url = "http://180.235.151.169:8002/";
    private static String ceUrl="http://47.94.175.112:8002/";

    private static HttpClient newIntance() {
        return new Retrofit.Builder().baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(HttpClient.class)
                ;
    }

    public interface HttpClient {

        @POST("v1/sms/getCode")
        Flowable<LoginInfo> getCode(@Body RequestBody boby); // 验证新老用户

        @POST("v1/banner/getBanner")
        Observable<ImageUrl> getBanner(); //获取banner

        @POST("v1/quick/login")
        Observable<LoginInfo> login(@Body RequestBody boby); //登录

        @POST("v1/product/getProduct")
        Observable<Product> getProduct(@Body RequestBody boby); //获取产品

        @POST("v1/product/apply")
        Observable<LoginInfo> apply(@Body RequestBody boby); //统计

        @POST("v1/product/detail")
        Observable<LoginInfo> detail(@Body RequestBody boby); //统计

    }
}

