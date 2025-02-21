package es.ulpgc.eite.da.templatedemo.first;

import java.lang.ref.WeakReference;

import android.util.Log;

import es.ulpgc.eite.da.templatedemo.app.AppMediator;
import es.ulpgc.eite.da.templatedemo.app.FirstToSecondState;
import es.ulpgc.eite.da.templatedemo.app.SecondToFirstState;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class FirstPresenter implements FirstContract.Presenter {

    public static String TAG = "FirstPresenter";

    private WeakReference<FirstContract.View> view;
    private AppMediator mediator;
    private FirstContract.Model model;
    private FirstState state;

    public FirstPresenter(AppMediator mediator) {
        Log.e(TAG, "createPresenter()");

        this.mediator = mediator;
    }

    @Override
    public void onCreateCalled() {
        Log.e(TAG, "onCreateCalled()");

        // call the mediator initialize the state
        initScreenState();

        /*
        // use saved state if is necessary
        SavedPreviousFirstState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onUpdatedDataFromPreviousScreen(savedState.data);

        }
        */
    }

    @Override
    public void onRecreateCalled() {
        Log.e(TAG, "onRecreateCalled()");

        // call the mediator to initialize the state
        state = getSavedScreenState();

        // update the model if is necessary
        model.onUpdatedDataFromRecreatedScreen(state.scrMsg);
    }

    @Override
    public void onResumeCalled() {
        Log.e(TAG, "onResumeCalled()");


        // use passed state if is necessary
        SecondToFirstState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onUpdatedDataFromNextScreen(savedState.msg);

        }

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
    public void onClearButtonClicked() {
        Log.e(TAG, "onClearButtonClicked()");

        // update the state and the model
        state.scrMsg = "";
        model.setCurrentData(state.scrMsg);

        view.get().onRefreshViewWithUpdatedData(state);
    }

    @Override
    public void onNextButtonClicked() {
        Log.e(TAG, "onNextButtonClicked()");

        FirstToSecondState newState = new FirstToSecondState();
        newState.msg = model.getStoredData();
        passStateToNextScreen(newState);

        view.get().navigateToNextScreen();
    }

    private void initScreenState() {
        Log.e(TAG, "initScreenState()");

        state = new FirstState();
        //state.scrMsg = model.getCurrentData();
    }

    private FirstState getSavedScreenState() {
        Log.e(TAG, "getSavedScreenState()");

        return mediator.getFirstScreenState();
    }

    private void saveScreenState() {
        Log.e(TAG, "saveScreenState()");

        mediator.setFirstScreenState(state);
    }


    private void resetScreenState() {
        Log.e(TAG, "resetScreenState()");

        mediator.resetFirstScreenState();
    }


    private SecondToFirstState getStateFromNextScreen() {
        Log.e(TAG, "getStateFromNextScreen()");

        return mediator.getNextFirstScreenState();
    }

    private void passStateToNextScreen(FirstToSecondState state) {
        Log.e(TAG, "passStateToNextScreen()");

        mediator.setNextFirstScreenState(state);
    }

    /*
    private void passStateToPreviousScreen(NewPreviousFirstState state) {
        mediator.setPreviousFirstScreenState(state);
    }

    private SavedPreviousFirstState getStateFromPreviousScreen() {
        return mediator.getPreviousFirstScreenState();
    }
    */

    @Override
    public void injectView(WeakReference<FirstContract.View> view) {
        Log.e(TAG, "injectView()");

        this.view = view;
    }

    @Override
    public void injectModel(FirstContract.Model model) {
        Log.e(TAG, "injectModel()");

        this.model = model;
    }

}