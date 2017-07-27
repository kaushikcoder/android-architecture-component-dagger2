package com.kaushik.myredmart.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.kaushik.myredmart.model.list.Product;
import com.kaushik.myredmart.model.list.Products;
import com.kaushik.myredmart.api.RedMartProductService;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kaushik on 18-04-2017.
 */
@Singleton
public class ProductListRepository {

    RedMartProductService mProductService;

    @Inject
    public ProductListRepository(RedMartProductService service){
        mProductService = service;
    }

    public Products getProductList(int pageNo) {
        final Products data = new Products();
        mProductService.getProducts(pageNo, 10).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                Products products = response.body();
                data.setPage(products.getPage());
                data.setOn_sale_count(products.getOn_sale_count());
                data.setPageSize(products.getPageSize());
                data.setProducts(products.getProducts());
                data.setTotal(products.getTotal());
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {

            }
        });
        return data;
    }


}
