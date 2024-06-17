package es.ulpgc.eite.da.templatedemo.second;

import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.templatedemo.R;
import es.ulpgc.eite.da.templatedemo.app.AppMediator;


// Project: Template Demo
// Created by Luis Hernandez on 17/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class SecondScreen {

    public static String TAG = "SecondScreen";

    public static void configure(SecondContract.View view) {
        Log.e(TAG, "configure()");

        WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        SecondContract.Presenter presenter = new SecondPresenter(mediator);

        SecondContract.Model model = new SecondModel();

        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}