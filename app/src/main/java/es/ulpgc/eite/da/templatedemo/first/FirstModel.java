package es.ulpgc.eite.da.templatedemo.first;

import android.util.Log;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class FirstModel implements FirstContract.Model {

    public static String TAG = "FirstModel";

    private String appMsg;
    private String scrMsg;
    private String newMsg;

    public FirstModel(String msg) {
        Log.e(TAG, "createModel()");

        scrMsg = "";
        appMsg = msg;
    }

    @Override
    public String getCurrentData() {
        Log.e(TAG, "getCurrentData()");

        return scrMsg;
    }

    @Override
    public String getStoredData() {
        Log.e(TAG, "getStoredData()");

        return appMsg;
    }

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
    public void onUpdatedDataFromRecreatedScreen(String msg) {
        Log.e(TAG, "onUpdatedDataFromRecreatedScreen()");

        scrMsg=msg;
    }

    @Override
    public void onUpdatedDataFromNextScreen(String msg) {
        Log.e(TAG, "onUpdatedDataFromNextScreen()");

        newMsg=msg;
        scrMsg=msg;
    }

    /*
    @Override
    public void onUpdatedDataFromPreviousScreen(String msg) {
        Log.e(TAG, "onUpdatedDataFromPreviousScreen()");

    }
    */
}