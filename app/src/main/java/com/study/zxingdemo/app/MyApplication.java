package com.study.zxingdemo.app;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by dengzhaoxuan on 2017/4/11.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        ZXingLibrary.initDisplayOpinion(this);
    }
}
