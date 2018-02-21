package com.sample.architecture.component.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.architecture.component.R;
import com.sample.architecture.component.adapter.CryptoAdapter;
import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.CoinPriceModel;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Timber.plant(new Timber.DebugTree());

        new MyLifeCycleObserver(this,getLifecycle());

    }

}
