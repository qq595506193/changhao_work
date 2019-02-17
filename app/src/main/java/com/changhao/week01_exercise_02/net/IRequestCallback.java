package com.changhao.week01_exercise_02.net;

public interface IRequestCallback {
    void onSuccess(String result);

    void onFailed(String msg);
}
