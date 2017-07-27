package com.kaushik.myredmart.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.kaushik.myredmart.model.list.Product;
import com.kaushik.myredmart.repository.ProductListRepository;
import com.kaushik.myredmart.model.list.Products;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kaushik on 18-04-2017.
 */

public class ProductListViewModel extends ViewModel {

    private final ProductListRepository mProductListRepository;
    private MutableLiveData<List<Product>> mProducts;
    private int pageNo=0;

    @Inject
    public ProductListViewModel(ProductListRepository productListRepository) {
        this.mProductListRepository = productListRepository;
        getProductList(pageNo);
    }

    private void getProductList(int pageNo) {

        Products products = mProductListRepository.getProductList(pageNo);
        if (products == null) {
            ///
        } else {
            List<com.kaushik.myredmart.model.list.Product> productList = new ArrayList<com.kaushik.myredmart.model.list.Product>();
            productList.addAll(mProducts.getValue());
            productList.addAll(products.getProducts());

            mProducts.setValue(productList);
        }
    }

    public void getProductListMore(){
        pageNo++;
        getProductList(pageNo);
    }

    @NonNull
    public LiveData<List<Product>> getProductList() {
        return mProducts;
    }
    /*@Override
    public void onProductListReceived(Products products) {
        if (products.getProducts().size() > 0) {
            mView.displayProducts(products.getProducts(), products.getPage());
        }
    }

    @Override
    public void onProductListError(String message) {
        mView.showError(message);
    }*/
}
