package com.lcp.mvpdemo.net;

/**
 * Created by Aislli on 2016/4/12.
 */
public class RetrofitFactory {
    private static Object object = new Object();
    static GitHubApi gitHubApi = null;
    static IpApi ipApi = null;

    public static GitHubApi getGitHubApi() {
        if (gitHubApi == null) {
            synchronized (object) {
                if (gitHubApi == null) {
                    gitHubApi = new RetrofitUtils().getGitHubApiService();
                }
            }
        }
        return gitHubApi;
    }

    public static IpApi getIpApi() {
        if (ipApi == null) {
            synchronized (object) {
                if (ipApi == null) {
                    ipApi = new RetrofitUtils().getIpApiService();
                }
            }
        }
        return ipApi;
    }
}
