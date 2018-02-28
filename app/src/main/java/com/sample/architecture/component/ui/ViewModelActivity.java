package com.sample.architecture.component.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.architecture.component.R;
import com.sample.architecture.component.adapter.CryptoAdapter;
import com.sample.architecture.component.api.ApiResponse;
import com.sample.architecture.component.model.CoinPriceModel;
import com.sample.architecture.component.viewmodel.CryptoViewModel;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class ViewModelActivity extends AppCompatActivity {

    private RecyclerView recyclerRepositoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Timber.plant(new Timber.DebugTree());

        recyclerRepositoryList = findViewById(R.id.cryptoPriceList);
        recyclerRepositoryList.setLayoutManager(new LinearLayoutManager(this));

        ViewModelProviders.of(this).get(CryptoViewModel.class)
                .getCryptoPrices()
                .observe(this, coinPriceModels -> {
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
