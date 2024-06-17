package es.ulpgc.eite.da.templatedemo.app;


import android.util.Log;

import es.ulpgc.eite.da.templatedemo.first.FirstState;
import es.ulpgc.eite.da.templatedemo.second.SecondState;

// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
@SuppressWarnings("unused")
public class AppMediator {

    public static String TAG = "AppMediator";

    private static AppMediator INSTANCE;

    private FirstState savedFirstState;
    private SecondState savedSecondState;

    private FirstToSecondState savedFirstToSecondState;
    private SecondToFirstState savedSecondToFirstState;

    private AppMediator() {
        Log.e(TAG, "createInstance()");

        //savedFirstState = new FirstState();
        //savedSecondState = new SecondState();
    }


    public static AppMediator getInstance() {
        Log.e(TAG, "getInstance()");

        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }

    // to reset the state when testing
    public static void resetInstance() {
        INSTANCE = null;
    }

    public FirstState getFirstScreenState() {
        return savedFirstState;
    }

    public void setFirstScreenState(FirstState state) {
        savedFirstState = state;
    }

    public void resetFirstScreenState() {
        savedFirstState = null;
    }

    public void setNextFirstScreenState(FirstToSecondState state) {
        savedFirstToSecondState=state;
    }

    public SecondToFirstState getNextFirstScreenState() {
        SecondToFirstState state = savedSecondToFirstState;
        savedSecondToFirstState=null;
        return state;
    }

    public void resetSecondScreenState() {
        savedSecondState=null;
    }

    public void setSecondScreenState(SecondState state) {
        savedSecondState=state;
    }

    public SecondState getSecondScreenState() {
        return savedSecondState;
    }

    public void setPreviousSecondScreenState(SecondToFirstState state) {
        savedSecondToFirstState=state;
    }

    public FirstToSecondState getPreviousSecondScreenState() {
        FirstToSecondState state = savedFirstToSecondState;
        savedFirstToSecondState=null;
        return state;
    }

    /*
    public void setPreviousFirstScreenState(NewPreviousFirstState state) {

    }

    public SavedPreviousFirstState getPreviousFirstScreenState() {
        return null;
    }
    */

}