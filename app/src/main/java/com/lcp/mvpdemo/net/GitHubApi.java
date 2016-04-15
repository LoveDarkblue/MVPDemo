package com.lcp.mvpdemo.net;

import com.lcp.mvpdemo.data.bean.GitHubUser;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Aislli on 2016/4/12.
 */
public interface GitHubApi {
    @GET("/users/{user}")
    Observable<GitHubUser> getGithubUser(@Path("user") String user);
}
