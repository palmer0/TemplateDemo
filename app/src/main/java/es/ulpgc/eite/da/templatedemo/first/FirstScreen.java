package es.ulpgc.eite.da.templatedemo.first;

import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.templatedemo.R;
import es.ulpgc.eite.da.templatedemo.app.AppMediator;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class FirstScreen {

    public static String TAG = "FirstScreen";

    public static void configure(FirstContract.View view) {
        Log.e(TAG, "configure()");

        WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);


        AppMediator mediator = AppMediator.getInstance();
        FirstContract.Presenter presenter = new FirstPresenter(mediator);

        Log.e(TAG, "getResources()");
        String msg = context.get().getString(R.string.app_msg);
        FirstContract.Model model = new FirstModel(msg);

        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}