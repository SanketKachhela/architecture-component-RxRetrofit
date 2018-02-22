package com.sample.architecture.component.ui;

import android.app.Application;
import android.arch.lifecycle.ProcessLifecycleOwner;

/**
 * Created by Simform Solution on 21/02/18.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ProcessLifecycleOwner
                .get()
                .getLifecycle()
                .addObserver(new MyLifeCycleObserver(this));
    }
}
