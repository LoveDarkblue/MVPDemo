package com.lcp.mvpdemo.ui.view;

/**
 * Created by Aislli on 2016/4/13.
 */
public interface IIPinfoView<T> extends IBaseView {
    void setViewData(T data);
    String getIpStr();//获取输入框里的信息
    void showError(String msg);
}
