package es.ulpgc.eite.da.templatedemo.first;

import java.lang.ref.WeakReference;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public interface FirstContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onRefreshViewWithUpdatedData(FirstViewModel viewModel);

        void navigateToNextScreen();

        //void navigateToPreviousScreen();
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

        void onClearButtonClicked();

        void onNextButtonClicked();
    }

    interface Model {
        String getCurrentData();

        String getStoredData();

        String getSavedData();

        void setCurrentData(String msg);

        void onUpdatedDataFromRecreatedScreen(String msg);

        void onUpdatedDataFromNextScreen(String msg);

        //void onUpdatedDataFromPreviousScreen(String msg);
    }

}