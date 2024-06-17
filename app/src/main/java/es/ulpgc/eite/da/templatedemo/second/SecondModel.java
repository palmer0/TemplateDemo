package es.ulpgc.eite.da.templatedemo.second;

import android.util.Log;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class SecondModel implements SecondContract.Model {

    public static String TAG = "SecondModel";

    private String appMsg;
    private String scrMsg;
    private String newMsg;

    public SecondModel() {
        Log.e(TAG, "createModel()");
    }

    @Override
    public String getCurrentData() {
        Log.e(TAG, "getCurrentData()");

        return scrMsg;
    }

    /*
    @Override
    public String getStoredData() {
        Log.e(TAG, "getStoredData()");

        return appMsg;
    }
    */

    @Override
    public String getSavedData() {
        Log.e(TAG, "getSavedData()");

        return newMsg;
    }

    @Override
    public void setCurrentData(String msg) {
        Log.e(TAG, "setCurrentData()");
        scrMsg=msg;
    }

    @Override
    public void onUpdatedDataFromRecreatedScreen(String scrMsg, String newMsg) {
        Log.e(TAG, "onUpdatedDataFromRecreatedScreen()");

        this.scrMsg=scrMsg;
        this.newMsg=newMsg;
    }

    /*
    @Override
    public void onUpdatedDataFromNextScreen(String msg) {
        Log.e(TAG, "onUpdatedDataFromNextScreen()");

    }
    */

    @Override
    public void onUpdatedDataFromPreviousScreen(String msg) {
        Log.e(TAG, "onUpdatedDataFromPreviousScreen()");

        newMsg=msg;
    }
}