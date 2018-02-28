package com.sample.architecture.component.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sample.architecture.component.R;

/**
 * Created by Simform Solution on 19/02/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_main);

        findViewById(R.id.btnLifeCycleActivity).setOnClickListener(view -> {
            startActivity(LifeCycleActivity.class);
        });

        findViewById(R.id.btnNormalActivity).setOnClickListener(view -> {
            startActivity(NormalActivity.class);
        });

        findViewById(R.id.btnLiveDataActivity).setOnClickListener(view -> {
            startActivity(LiveDataActivity.class);
        });

        findViewById(R.id.btnViewModelActivity).setOnClickListener(view -> {
            startActivity(ViewModelActivity.class);
        });
    }

    private void startActivity(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
