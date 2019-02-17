package com.changhao.week01_exercise_02.model;

import com.changhao.week01_exercise_02.apis.ParticularsApi;
import com.changhao.week01_exercise_02.contract.IParticularsContract;
import com.changhao.week01_exercise_02.net.IOkHttpCallback;
import com.changhao.week01_exercise_02.net.IRequestCallback;
import com.changhao.week01_exercise_02.utils.RetrofitUtils;

import java.util.HashMap;

public class ParticularsModel implements IParticularsContract.IParticularsModel {
    @Override
    public void getParticulars(HashMap<String, String> params, final IRequestCallback iRequestCallback) {
        RetrofitUtils.getInstance().doGet(ParticularsApi.PL_URL, params, new IOkHttpCallback() {
            @Override
            public void onSuccess(String result) {
                if (iRequestCallback != null) {
                    iRequestCallback.onSuccess(result);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (iRequestCallback != null) {
                    iRequestCallback.onFailed(msg);
                }
            }
        });
    }
}
