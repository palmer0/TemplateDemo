package es.ulpgc.eite.da.templatedemo.second;

import java.lang.ref.WeakReference;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public interface SecondContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onRefreshViewWithUpdatedData(SecondViewModel viewModel);

        //void navigateToNextScreen();

        void navigateToPreviousScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResumeCalled();

        void onCreateCalled();

        void onRecreateCalled();

        void onBackButtonPressed();

        void onPauseCalled();

        void onDestroyCalled();

      void onShowButtonClicked();

        void onBackButtonClicked();
    }

    interface Model {
        String getCurrentData();

        //String getStoredData();

        String getSavedData();

        void onUpdatedDataFromRecreatedScreen(String scrMsg, String newMsg);

        //void onUpdatedDataFromNextScreen(String msg);

        void onUpdatedDataFromPreviousScreen(String msg);

        void setCurrentData(String msg);
    }

}