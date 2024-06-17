package es.ulpgc.eite.da.templatedemo.second;

import java.lang.ref.WeakReference;

import android.util.Log;

import es.ulpgc.eite.da.templatedemo.app.AppMediator;
import es.ulpgc.eite.da.templatedemo.app.FirstToSecondState;
import es.ulpgc.eite.da.templatedemo.app.SecondToFirstState;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class SecondPresenter implements SecondContract.Presenter {

    public static String TAG = "SecondPresenter";

    private WeakReference<SecondContract.View> view;
    private AppMediator mediator;
    private SecondContract.Model model;
    private SecondState state;

    public SecondPresenter(AppMediator mediator) {
        Log.e(TAG, "createPresenter()");

        this.mediator = mediator;
    }

    @Override
    public void onCreateCalled() {
        Log.e(TAG, "onCreateCalled()");

        // call the mediator initialize the state
        initScreenState();


        // use saved state if is necessary
        FirstToSecondState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onUpdatedDataFromPreviousScreen(savedState.msg);
        }

    }

    @Override
    public void onRecreateCalled() {
        Log.e(TAG, "onRecreateCalled()");

        // call the mediator to initialize the state
        state = getSavedScreenState();

        // update the model if is necessary
        model.onUpdatedDataFromRecreatedScreen(state.scrMsg, state.newMsg);
    }

    @Override
    public void onResumeCalled() {
        Log.e(TAG, "onResumeCalled()");

        /*
        // use passed state if is necessary
        SavedNextSecondState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onUpdatedDataFromNextScreen(savedState.data);

        }
        */

        // call the model and initialize the state
        state.scrMsg = model.getCurrentData();

        // update the view
        view.get().onRefreshViewWithUpdatedData(state);

    }

    @Override
    public void onBackButtonPressed() {
        Log.e(TAG, "onBackButtonPressed()");

    }

    @Override
    public void onPauseCalled() {
        Log.e(TAG, "onPauseCalled()");

        // save the state
        saveScreenState();
    }

    @Override
    public void onDestroyCalled() {
        Log.e(TAG, "onDestroyCalled()");

        // reset the state if is necessary
        //resetScreenState();
    }

    @Override
    public void onShowButtonClicked() {
        Log.e(TAG, "onShowButtonClicked()");

        // update the state and the model
        state.scrMsg = model.getSavedData();
        model.setCurrentData(state.scrMsg);

        // update the view
        view.get().onRefreshViewWithUpdatedData(state);
    }

    @Override
    public void onBackButtonClicked() {
        Log.e(TAG, "onBackButtonClicked()");

        SecondToFirstState newState = new SecondToFirstState();
        newState.msg = state.scrMsg;
        passStateToPreviousScreen(newState);

        view.get().navigateToPreviousScreen();
    }


    private void initScreenState() {
        Log.e(TAG, "initScreenState()");

        state = new SecondState();
    }

    private SecondState getSavedScreenState() {
        Log.e(TAG, "getSavedScreenState()");

        return mediator.getSecondScreenState();
    }

    private void saveScreenState() {
        Log.e(TAG, "saveScreenState()");

        mediator.setSecondScreenState(state);
    }


    private void resetScreenState() {
        Log.e(TAG, "resetScreenState()");

        mediator.resetSecondScreenState();
    }


    /*
    private SavedNextSecondState getStateFromNextScreen() {
        return mediator.getNextSecondScreenState();
    }

    private void passStateToNextScreen(NewNextSecondState state) {
        mediator.setNextSecondScreenState(state);
    }
    */

    private void passStateToPreviousScreen(SecondToFirstState state) {
        Log.e(TAG, "passStateToPreviousScreen()");

        mediator.setPreviousSecondScreenState(state);
    }

    private FirstToSecondState getStateFromPreviousScreen() {
        Log.e(TAG, "getStateFromPreviousScreen()");

        return mediator.getPreviousSecondScreenState();
    }

    @Override
    public void injectView(WeakReference<SecondContract.View> view) {
        Log.e(TAG, "injectView()");

        this.view = view;
    }

    @Override
    public void injectModel(SecondContract.Model model) {
        Log.e(TAG, "injectModel()");

        this.model = model;
    }

}