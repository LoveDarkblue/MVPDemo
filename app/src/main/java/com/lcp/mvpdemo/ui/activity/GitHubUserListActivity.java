package com.lcp.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.lcp.mvpdemo.R;
import com.lcp.mvpdemo.data.bean.GitHubUser;
import com.lcp.mvpdemo.presenter.GitHubUserListPresenter;
import com.lcp.mvpdemo.ui.adapter.GithubUserListAdapter;
import com.lcp.mvpdemo.ui.view.IGitHubUserListView;
import com.lcp.mvpdemo.widget.ARecycleView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Aislli on 2016/4/12.
 */
public class GitHubUserListActivity extends BaseActivity<GitHubUserListPresenter> implements IGitHubUserListView<GitHubUser> {
    @Bind(R.id.recycler_view)
    ARecycleView recyclerView;
    private GithubUserListAdapter githubUserListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<GitHubUser> gitHubUsers = new ArrayList<>();

    @Override
    protected void initPresenter() {
        mPresenter = new GitHubUserListPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_githubuser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GitHub", true);
        initRecyclerView();
        mPresenter.initData();
    }

    private void initRecyclerView() {
        githubUserListAdapter = new GithubUserListAdapter(this, gitHubUsers);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(githubUserListAdapter);
        setListener();
    }

    private void setListener() {
        recyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .doOnNext(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                Toast.makeText(getApplicationContext(), "onRefresh", Toast.LENGTH_SHORT).show();
                                recyclerView.setRefreshing(false);
                                linearLayoutManager.scrollToPosition(0);
                            }
                        })
                        .subscribe();
            }
        });

        recyclerView.setOnLoadMoreListener(new ARecycleView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .doOnNext(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                List<String> users = new ArrayList<>();
                                users.add("jakewharton");
                                users.add("greenrobot");
                                mPresenter.getServiceData(users);
                            }
                        })
                        .subscribe();
            }
        });

    }

    @Override
    public void addData(GitHubUser data) {
        githubUserListAdapter.add(data);
    }

    @Override
    public void hideLoading() {
        recyclerView.hideLoading();
    }

    @Override
    public void setTotal(int count) {
        recyclerView.setTotal(count);
    }

    @Override
    public void showRefresh() {
        recyclerView.setRefreshing(true);
    }
}
