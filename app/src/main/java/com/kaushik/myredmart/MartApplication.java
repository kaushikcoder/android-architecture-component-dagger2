package com.kaushik.myredmart;

import android.app.Activity;
import android.app.Application;

import com.kaushik.myredmart.di.AppComponent;
import com.kaushik.myredmart.di.AppInjector;
//import com.kaushik.myredmart.di.DaggerAppComponent;
import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Kaushik on 25-07-2017.
 */

public class MartApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
