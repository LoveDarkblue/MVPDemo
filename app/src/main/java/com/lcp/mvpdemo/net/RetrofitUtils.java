package com.lcp.mvpdemo.net;

import android.annotation.TargetApi;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lcp.mvpdemo.BaseApplication;
import com.lcp.mvpdemo.R;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by mine on 2016/2/23.
 */
public class RetrofitUtils {

    final GitHubApi apiService;
    final IpApi ipService;

    RetrofitUtils() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkhttpClient());
        Retrofit retrofit = builder.build();
        apiService = retrofit.create(GitHubApi.class);
        builder.baseUrl("http://ip.taobao.com");
        Retrofit retrofit1 = builder.build();
        ipService = retrofit1.create(IpApi.class);
    }

    public GitHubApi getGitHubApiService() {
        return apiService;
    }

    public IpApi getIpApiService() {
        return ipService;
    }

    private OkHttpClient getOkhttpClient() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .addHeader("User-Agent", "Test")
                        .addHeader("Accept", "application/vnd.github.v3+json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        };

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(headerInterceptor);
        builder.sslSocketFactory(createBadSslSocketFactory());
//        builder.sslSocketFactory(getSSLConfig().getSocketFactory());

        return builder.build();
    }

    /* SSL Config
         *
          * openssl x509 -outform der -in your-cert.pem -out your-cert.crt
          * */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static SSLContext getSSLConfig() {
        try {
            CertificateFactory cf;
            cf = CertificateFactory.getInstance("X.509");

            Certificate ca;
            try (InputStream cert = BaseApplication.getContext().getResources().openRawResource(R.raw.test)) {
                ca = cf.generateCertificate(cert);
            }

            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            return sslContext;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    private static SSLSocketFactory createBadSslSocketFactory() {
        try {
            // Construct SSLSocketFactory that accepts any cert.
            SSLContext context = SSLContext.getInstance("TLS");
            TrustManager permissive = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }


                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }


                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            context.init(null, new TrustManager[]{permissive}, null);
            return context.getSocketFactory();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
