package com.kaushik.myredmart.di;

import android.app.Application;

import com.kaushik.myredmart.MartApplication;
import com.kaushik.myredmart.ui.ProductDetailsActivity;
import com.kaushik.myredmart.ui.ProductListActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Kaushik on 21-07-2017.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityModule.class, AppModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MartApplication martApp);
}
