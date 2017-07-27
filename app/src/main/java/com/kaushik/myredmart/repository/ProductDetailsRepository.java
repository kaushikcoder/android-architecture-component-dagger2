package com.kaushik.myredmart.repository;

import android.util.Log;

import com.kaushik.myredmart.api.RedMartProductService;
import com.kaushik.myredmart.model.details.ProductInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kaushik on 19-04-2017.
 */
@Singleton
public class ProductDetailsRepository {

    RedMartProductService mProductService;

    @Inject
    public ProductDetailsRepository(RedMartProductService service){
        mProductService = service;
    }

    public ProductInfo getProductDetails(int productId) {
        final ProductInfo data = new ProductInfo();
        mProductService.getProductDetails(productId).enqueue(new Callback<ProductInfo>() {
            @Override
            public void onResponse(Call<ProductInfo> call, Response<ProductInfo> response) {
                ProductInfo productInfo = response.body();
                data.setter(productInfo.getTotal(), productInfo.getProduct(), productInfo.getStatus());
            }

            @Override
            public void onFailure(Call<ProductInfo> call, Throwable t) {

            }
        });

        return data;
    }
}
