package com.sample.architecture.component.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.sample.architecture.component.api.ApiResponse;
import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.RepositoryList;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class RepositoryViewModel extends ViewModel {

    private LiveData<ApiResponse<RepositoryList>> data;

    public LiveData<ApiResponse<RepositoryList>> getUserData() {
        if (data == null) {
            data = FetchServiceBase.getFetcherService().getRepositoryListbyLanguage();
            return data;
        }
        return data;
    }
}
