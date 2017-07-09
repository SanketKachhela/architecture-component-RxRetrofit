package com.sample.architecture.component.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.sample.architecture.component.api.FetchServiceBase;
import com.sample.architecture.component.model.RepositoryList;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



/**
 * Created by Sanket Kachhela on 04-07-2017.
 */

public class RepositoryViewModel extends ViewModel {

    private MutableLiveData<RepositoryList> data;

    public LiveData<RepositoryList> getUserData() {
        if (data == null) {
            data = new MutableLiveData<>();
            FetchServiceBase.getFetcherService().getRepositoryListbyLanguage()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userList -> data.setValue(userList), Throwable::printStackTrace);
            return data;
        }
        return data;
    }
}
