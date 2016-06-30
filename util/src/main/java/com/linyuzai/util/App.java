package com.linyuzai.util;

import android.content.Context;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class App {
    public static final String TAG = "App";
    private static Context context;

    public static void bind(Context context) {
        App.context = context;
    }

    public static Context getContext() {
        return context;
    }

    public static Context checkNull(Context context) {
        if (context == null)
            throw new NullPointerException("you need use App.bind() before use this constructor");
        return context;
    }
}
