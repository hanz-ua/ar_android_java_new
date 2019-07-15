package com.bvblogic.examplearbvb.api.networking.module;

import android.annotation.SuppressLint;

import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.api.networking.LoginNetworking;
import com.bvblogic.examplearbvb.api.service.LoginService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private File cacheFile;
    private String url;

    BaseActivity baseActivity;

    public NetworkModule(File cacheFile, String url, BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        this.cacheFile = cacheFile;
        this.url = url;
    }

    @Provides
    @Singleton
    Retrofit providerCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
        SSLSocketFactory sslSocketFactory = null;
        // Install the all-trusting trust manager
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request origin = chain.request();

                    Request request = origin.newBuilder()
                            .header("Content-Type",
                                    "application/json")
                            .header("Api-client",
                                    "Mobile")
                            .header("Cache-Control",
                                    "max-age=432000")
                            .build();

                    Response response = chain.proceed(request);
                    response.cacheResponse();
                    return response;
                })
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .addInterceptor(chain -> {
//                    Request originalRequest = chain.request();
//                    Response response = chain.proceed(originalRequest);
//                    bodyToString(response.body())
//                    // PreferencesBean_.getInstance_(baseActivity).saveToken(response.headers().get("ACTIVE_TOKEN"));
//                    return response;
//                })
                .cache(cache)
                .sslSocketFactory(sslSocketFactory)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create()
                ).build();

    }


    @Provides
    @Singleton
    public LoginService providerLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @Provides
    @Singleton
    public LoginNetworking providesNetworkLogin(LoginService loginService) {
        return new LoginNetworking(loginService);
    }

}
