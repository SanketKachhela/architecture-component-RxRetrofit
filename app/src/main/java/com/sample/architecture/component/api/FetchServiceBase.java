package com.sample.architecture.component.api;


import com.sample.architecture.component.BuildConfig;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class FetchServiceBase {

    private static FetchService fetchService;

    private static Retrofit GetRestAdapter(boolean isNormalAdapter) {

        //setup cache
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(loggingInterceptor)
                .readTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES);

        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(isNormalAdapter?RxJavaCallAdapterFactory.create():new LiveDataCallAdapterFactory())
                .client(client)
                .build();
    }

    public static FetchService getFetcherService(boolean isNormalAdapter) {
        if(fetchService == null)
            return GetRestAdapter(isNormalAdapter).create(FetchService.class);
        else
            return fetchService;
    }


}