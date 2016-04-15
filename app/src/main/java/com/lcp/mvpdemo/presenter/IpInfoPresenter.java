package com.lcp.mvpdemo.presenter;

import android.util.Log;

import com.lcp.mvpdemo.data.IpData;
import com.lcp.mvpdemo.data.bean.IpInfo;
import com.lcp.mvpdemo.net.RetrofitFactory;
import com.lcp.mvpdemo.ui.view.IIPinfoView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Aislli on 2016/4/13.
 */
public class IpInfoPresenter extends BasePresenter<IIPinfoView> {
    public IpInfoPresenter(IIPinfoView view) {
        super(view);
    }

    public void getData(){
        RetrofitFactory.getIpApi().getIPinfo(mView.getIpStr())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<IpData, IpInfo>() {
                    @Override
                    public IpInfo call(IpData ipData) {
                        return ipData.data;
                    }
                })
                .subscribe(new Subscriber<IpInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError", e.getMessage());
                        mView.showError("invaild ip.");
                    }

                    @Override
                    public void onNext(IpInfo ipInfo) {
                        if (null != ipInfo) {
                            mView.setViewData(ipInfo);
                        }else{
                            mView.showError("invaild ip.");
                        }
                    }
                });
    }
}
