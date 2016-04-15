package com.lcp.mvpdemo.presenter;

import com.lcp.mvpdemo.ui.view.IBaseView;


public class BasePresenter<GV extends IBaseView> {

    protected GV mView;

    public BasePresenter(GV view) {
        mView = view;
    }
}
