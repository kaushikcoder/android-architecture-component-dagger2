package com.kaushik.myredmart.api;

import com.kaushik.myredmart.model.details.ProductInfo;
import com.kaushik.myredmart.model.list.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
//import rx.Observable;

/**
 * Created by Kaushik on 18-04-2017.
 */


public interface RedMartProductService {

    @GET("/search")
    public Call<Products> getProducts(@Query("page") int page, @Query("pageSize") int productNo);

    @GET("/products/{productId}")
    public Call<ProductInfo> getProductDetails(@Path("productId") int productId);
}

