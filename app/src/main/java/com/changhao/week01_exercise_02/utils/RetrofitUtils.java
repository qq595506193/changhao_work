package com.changhao.week01_exercise_02.utils;

import com.changhao.week01_exercise_02.apis.Api;
import com.changhao.week01_exercise_02.net.IOkHttpCallback;
import com.changhao.week01_exercise_02.net.RetrofitService;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils instance;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;


    private RetrofitUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
        // 创建Retrofit管理者
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())// 构造工厂
                .client(okHttpClient)
                .build();
    }

    // 单例双重检验锁
    public static RetrofitUtils getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtils.class) {
                if (instance == null) {
                    instance = new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    public void doGet(String apiUrl, HashMap<String,String> params, final IOkHttpCallback iOkHttpCallback) {

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        retrofitService.getReg(apiUrl).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.code() == 200) {

                    String result = response.body().string();
                        if (iOkHttpCallback != null) {
                            iOkHttpCallback.onSuccess(result);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (iOkHttpCallback != null) {
                    iOkHttpCallback.onFailed("网络不稳定请稍后重试");
                }
            }
        });

    }

    public void doPost(String apiUrl, HashMap<String,String> params, final IOkHttpCallback iOkHttpCallback) {

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.postReg(apiUrl,params).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.code() == 200) {
                        String result = response.body().string();
                        if (iOkHttpCallback != null) {
                            iOkHttpCallback.onSuccess(result);
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (iOkHttpCallback != null) {
                    iOkHttpCallback.onFailed("网络不稳定，请稍后重试");
                }
            }
        });

    }
}
