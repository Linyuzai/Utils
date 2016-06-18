package com.linyuzai.util.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.linyuzai.util.App;

/**
 * Created by Administrator on 2016/6/19 0019.
 */
public class XSharedPrefs {
    public static final String DEFAULT_NAME = "shared_prefs";
    public static final String DEFAULT_STRING_VALUE = "0";
    public static final int DEFAULT_INT_VALUE = 0;

    private SharedPreferences sharedPref;

    private XSharedPrefs(Context context) {
        sharedPref = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
    }

    private static XSharedPrefs instance = null;

    public static XSharedPrefs getInstance() {
        return getInstance(App.getContext());
    }

    public static XSharedPrefs getInstance(Context context) {
        if (instance == null) {
            instance = new XSharedPrefs(context);
        }
        return instance;
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        return sharedPref.getString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue) {
        return sharedPref.getInt(key, defaultValue);
    }

    public String getString(String key) {
        return sharedPref.getString(key, DEFAULT_STRING_VALUE);
    }

    public int getInt(String key) {
        return sharedPref.getInt(key, DEFAULT_INT_VALUE);
    }
}
