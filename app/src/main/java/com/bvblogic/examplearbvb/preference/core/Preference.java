package com.bvblogic.examplearbvb.preference.core;

/**
 * Created by hanz on 10.05.2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public abstract class Preference {
    private static final String MY_PREFERENCES = "TestToTestPreferences";
    public static final String TOKEN_KEY = "token";
    private SharedPreferences sharedpreferences;

    @RootContext
    protected Activity activity;

    @AfterInject
    public void init() {
        sharedpreferences = activity.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
    }

    protected void savePreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    protected void savePreferencesString(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    protected void savePreferences(String key, float value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    protected void savePreferences(String key, boolean value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    protected void savePreferences(String key, int value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    protected void remove(String key) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    protected String getPreferencesString(String key) {
        return sharedpreferences.getString(key, "");
    }

    protected double getPreferencesDouble(String key) {
        return sharedpreferences.getFloat(key, 0f);
    }

    protected int getPreferencesInt(String key) {
        return sharedpreferences.getInt(key, 0);
    }

    protected Boolean getPreferencesBoolean(String key) {
        return sharedpreferences.getBoolean(key, true);
    }

    protected Boolean getPreferencesBooleanDefFalse(String key) {
        return sharedpreferences.getBoolean(key, false);
    }
}
