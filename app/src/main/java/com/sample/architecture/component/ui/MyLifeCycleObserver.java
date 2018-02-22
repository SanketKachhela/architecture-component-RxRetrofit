package com.sample.architecture.component.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Simform Solution on 16/02/18.
 */


public class MyLifeCycleObserver implements LifecycleObserver {

    private Context context;
    private Lifecycle lifecycle;

    MyLifeCycleObserver(Context context, Lifecycle lifecycle) {
        this.context = context;
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    MyLifeCycleObserver(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onPauseEvent() {
        Toast.makeText(context, "ON_RESUME", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyEvent() {
        Toast.makeText(context, "ON_DESTROY", Toast.LENGTH_SHORT).show();
        lifecycle.removeObserver(this);
    }
}











