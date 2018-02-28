package com.sample.architecture.component.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;

import com.sample.architecture.component.api.ApiResponse;
import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.CoinPriceModel;

import java.util.ArrayList;


/**
 * Created by Simform Solution on 17/02/18.
 */

    public class CryptoUpdateManager extends LiveData<ApiResponse<ArrayList<CoinPriceModel>>> {

        private LifecycleOwner lifecycleOwner;

        CryptoUpdateManager(LifecycleOwner lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
        }

        @Override
        protected void onActive() {
            super.onActive();
            FetchServiceBase.getFetcherService(false)
                    .getCoinPrice()
                    .observe(lifecycleOwner, repositoryListApiResponse -> {
                setValue(repositoryListApiResponse);
            });
        }

        @Override
        protected void onInactive() {
            super.onInactive();
        }
    }










