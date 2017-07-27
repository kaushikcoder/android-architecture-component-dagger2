package com.kaushik.myredmart.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.kaushik.myredmart.viewmodel.ProductDetailsViewModel;
import com.kaushik.myredmart.viewmodel.ProductListViewModel;
import com.kaushik.myredmart.viewmodel.ProductViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Kaushik on 25-07-2017.
 */

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel.class)
    abstract ViewModel bindProductListViewModel(ProductListViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel.class)
    abstract ViewModel bindProductDetailsViewModel(ProductDetailsViewModel detailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ProductViewModelFactory factory);
}
