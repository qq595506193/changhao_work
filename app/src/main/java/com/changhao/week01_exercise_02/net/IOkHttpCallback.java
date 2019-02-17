package com.changhao.week01_exercise_02.net;

public interface IOkHttpCallback {
    void onSuccess(String result);

    void onFailed(String msg);
}
