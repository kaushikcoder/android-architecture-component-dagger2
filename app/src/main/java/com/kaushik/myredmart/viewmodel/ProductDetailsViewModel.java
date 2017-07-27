package com.kaushik.myredmart.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kaushik.myredmart.repository.ProductDetailsRepository;
import com.kaushik.myredmart.model.details.ProductInfo;

import javax.inject.Inject;

/**
 * Created by Kaushik on 19-04-2017.
 */

public class ProductDetailsViewModel extends ViewModel {

    private final ProductDetailsRepository mProductDetailsRepository;
    private MutableLiveData<ProductInfo> mProductInfo;

    @Inject
    public ProductDetailsViewModel(ProductDetailsRepository repository) {
        this.mProductDetailsRepository = repository;
    }

    public void getProductDetails(int productId) {
        ProductInfo info = mProductDetailsRepository.getProductDetails(productId);
        if(info!=null) {
            mProductInfo.setValue(info);
        }else{
            ////
        }
    }

    public MutableLiveData<ProductInfo> getProductInfo() {
        return mProductInfo;
    }

    /*public void onProductListError(String message) {
        mView.showError(message);
    }*/
}
