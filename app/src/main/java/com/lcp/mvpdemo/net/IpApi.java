package com.lcp.mvpdemo.net;

import com.lcp.mvpdemo.data.IpData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Aislli on 2016/4/12.
 */
public interface IpApi {
    @GET("/service/getIpInfo.php")
    Observable<IpData> getIPinfo(@Query("ip") String ip);
}
