package com.sample.architecture.component.api;

import android.arch.lifecycle.LiveData;

import com.sample.architecture.component.model.RepositoryList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Sanket Kachhela on 09-07-2017.
 */

public interface FetchService {

    @GET("/search/repositories?q=kotlin:assembly&sort=stars&order=desc")
    LiveData<ApiResponse<RepositoryList>> getRepositoryListbyLanguage();
}
