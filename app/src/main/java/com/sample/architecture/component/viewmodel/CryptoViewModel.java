package com.sample.architecture.component.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.sample.architecture.component.api.ApiResponse;
import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.CoinPriceModel;

import java.util.ArrayList;


/**
 * Created by Sanket Kachhela on 04-07-2017.
 */




    public class CryptoViewModel extends ViewModel {

        private LiveData<ApiResponse<ArrayList<CoinPriceModel>>> data;

        public LiveData<ApiResponse<ArrayList<CoinPriceModel>>> getCryptoPrices() {
            if (data == null) {
                data = FetchServiceBase.getFetcherService(false).getCoinPrice();
                return data;
            }
            return data;
        }
    }







