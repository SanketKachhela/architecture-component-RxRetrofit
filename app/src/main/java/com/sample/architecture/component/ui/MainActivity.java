package com.sample.architecture.component.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.sample.architecture.component.R;
import com.sample.architecture.component.adapter.RepositoryAdapter;
import com.sample.architecture.component.viewmodel.RepositoryViewModel;

import timber.log.Timber;

/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class MainActivity extends LifecycleActivity {

    private RecyclerView recyclerRepositoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerRepositoryList = (RecyclerView) findViewById(R.id.repositoryList);
        recyclerRepositoryList.setLayoutManager(new LinearLayoutManager(this));

        Timber.plant(new Timber.DebugTree());

        ViewModelProviders.of(this).get(RepositoryViewModel.class).getUserData().observe(this, repositoryList -> {
            if(repositoryList.isSuccessful()){
                recyclerRepositoryList.setAdapter(new RepositoryAdapter(repositoryList.body.getItems()));
            }else{
                Timber.e(repositoryList.errorMessage);
            }

        });



    }
}
