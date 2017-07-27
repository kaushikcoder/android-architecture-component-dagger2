package com.kaushik.myredmart.di;

import com.kaushik.myredmart.api.RedMartProductService;
import com.kaushik.myredmart.repository.ProductDetailsRepository;
import com.kaushik.myredmart.repository.ProductListRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Kaushik on 20-07-2017.
 */
@Module(includes = ViewModelModule.class)
class AppModule {

    @Provides
    @Singleton
    RedMartProductService provideRedMartProductService() {
          final String REDMART_SERVER_URL = "https://api.redmart.com/v1.5.7/catalog/";

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(REDMART_SERVER_URL)
                .build()
                .create(RedMartProductService.class);
    }

    /*@Provides
    ViewModelProvider.Factory provideViewModelFactory(ProductViewModelFactory factory) {
        return factory;
    }

    @Provides
    ViewModel provideProductListViewModel(ProductListViewModel viewModel) {
        return viewModel;
    }

    @Provides
    ViewModel provideProductDetailsViewModel(ProductDetailsViewModel viewModel) {
        return viewModel;
    }*/
/*
    @Binds
    @Singleton
    abstract ProductListRepository provideProductListRepository(ProductListRepositoryImpl repository);

    @Binds
    @Singleton
    abstract ProductListRepository provideProductDetailsRepository(ProductDetailsRepositoryImpl repository);

    @Provides
    @Singleton
    ProductDetailsRepository provideProductDetailsRepository(ProductDetailsRepository repository) {
        return repository;
    }*/
}
