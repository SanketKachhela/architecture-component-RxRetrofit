package com.sample.architecture.component.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.architecture.component.R;
import com.sample.architecture.component.adapter.CryptoAdapter;
import com.sample.architecture.component.api.ApiResponse;
import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.CoinPriceModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class LiveDataActivity extends AppCompatActivity {

    private RecyclerView recyclerRepositoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Timber.plant(new Timber.DebugTree());

        recyclerRepositoryList = findViewById(R.id.cryptoPriceList);
        recyclerRepositoryList.setLayoutManager(new LinearLayoutManager(this));

        LiveData<ApiResponse<ArrayList<CoinPriceModel>>> priceListener =
                new CryptoUpdateManager(this);
        priceListener.observe(this, coinPriceModels -> {
            setData(coinPriceModels);
        });

    }

    private void setData(ApiResponse<ArrayList<CoinPriceModel>> repositoryList){
        if(repositoryList.isSuccessful()){
            recyclerRepositoryList.setAdapter(new CryptoAdapter(repositoryList.body));
        }else{
            Timber.e(repositoryList.errorMessage);
        }
    }
}