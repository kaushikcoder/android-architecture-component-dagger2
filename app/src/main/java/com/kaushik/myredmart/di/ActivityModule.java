package com.kaushik.myredmart.di;

import com.kaushik.myredmart.ui.ProductDetailsActivity;
import com.kaushik.myredmart.ui.ProductListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Kaushik on 26-07-2017.
 */

    @Module
    public abstract class ActivityModule {
        @ContributesAndroidInjector
        abstract ProductListActivity contributeProductListActivity();

        @ContributesAndroidInjector
        abstract ProductDetailsActivity contributeProductDetailsActivity();
    }
