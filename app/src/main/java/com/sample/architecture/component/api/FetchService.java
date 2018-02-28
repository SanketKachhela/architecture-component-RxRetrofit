package com.sample.architecture.component.api;

import android.arch.lifecycle.LiveData;
import android.databinding.ObservableArrayList;

import com.sample.architecture.component.model.CoinPriceModel;
import java.util.ArrayList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Sanket Kachhela on 09-07-2017.
 */

public interface FetchService {

    @GET("ticker/?limit=1000")
    LiveData<ApiResponse<ArrayList<CoinPriceModel>>> getCoinPrice();

    @GET("ticker/?limit=1000")
    Observable<ArrayList<CoinPriceModel>> getCoinPriceNormal();
}
