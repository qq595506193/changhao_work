package com.changhao.week01_exercise_02.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        onFresco();
    }

    private void onFresco() {
        Fresco.initialize(this);
    }

}
