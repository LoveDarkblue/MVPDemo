package com.lcp.mvpdemo.presenter;

import android.util.Log;

import com.lcp.mvpdemo.data.bean.GitHubUser;
import com.lcp.mvpdemo.net.RetrofitFactory;
import com.lcp.mvpdemo.ui.view.IGitHubUserListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aislli on 2016/4/13.
 */
public class GitHubUserListPresenter extends BasePresenter<IGitHubUserListView> {
    public GitHubUserListPresenter(IGitHubUserListView view) {
        super(view);
    }

    public void initData(){
        List<String> users = new ArrayList<>();
        users.add("jakewharton");
        users.add("liangzhitao");
        users.add("AlanCheen");
        users.add("yongjhih");
        users.add("zzz40500");
        users.add("greenrobot");
        users.add("nimengbo");
        mView.showRefresh();
        getServiceData(users);
    }

    public void getServiceData(List<String> users){
        Observable.merge(getGitHubuserObservableList(users))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GitHubUser>() {
                    @Override
                    public void onCompleted() {
                        mView.hideLoading();
                        mView.setTotal(15);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("onError", throwable.getMessage());
                        mView.hideLoading();
                    }

                    @Override
                    public void onNext(GitHubUser gitHubUser) {
                        if (null != gitHubUser) {
                            mView.addData(gitHubUser);
                        }
                    }
                });
    }

    private List<Observable<GitHubUser>> getGitHubuserObservableList(List<String> users) {
        ArrayList<Observable<GitHubUser>> observables = new ArrayList<>();
        for (String user : users) {
            Observable<GitHubUser> githubUser = RetrofitFactory.getGitHubApi().getGithubUser(user);
            observables.add(githubUser);
        }
        return observables;
    }
}
