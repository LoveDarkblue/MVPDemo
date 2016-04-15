package com.lcp.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Aislli on 2016/2/23.
 */
public class BaseApplication extends Application {
    protected static String TAG = "BaseApplication";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Fresco.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
