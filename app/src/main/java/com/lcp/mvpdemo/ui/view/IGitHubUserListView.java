package com.lcp.mvpdemo.ui.view;

/**
 * Created by Aislli on 2016/4/13.
 */
public interface IGitHubUserListView<T> extends IBaseView{
    void addData(T data);
    void hideLoading();
    void setTotal(int count);
    void showRefresh();
}
