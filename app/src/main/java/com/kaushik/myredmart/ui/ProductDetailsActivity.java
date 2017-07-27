package com.kaushik.myredmart.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kaushik.myredmart.MartApplication;
import com.kaushik.myredmart.adapter.ImageSlideAdapter;
import com.kaushik.myredmart.di.Injectable;
import com.kaushik.myredmart.model.details.Product;
import com.kaushik.myredmart.model.details.ProductInfo;
import com.kaushik.myredmart.viewmodel.ProductDetailsViewModel;
import com.kaushik.myredmart.utility.CirclePageIndicator;
import com.kaushik.myredmart.utility.Util;

import javax.inject.Inject;

public class ProductDetailsActivity extends LifecycleActivity implements Injectable {

    private int productId;
    private ProductDetailsViewModel mProductDetailsViewModel;

    private TextView productTitle;
    private ViewPager mImagePager;
    private CirclePageIndicator mIndicator;
    private Product selectedProduct;
    private TextView productDefTextView;
    private TextView productWightTextView;
    private TextView originalPriceTextView;
    private TextView aboutProductTextView;
    private TextView priceTextView;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productId = getIntent().getIntExtra(Util.ProductId, 0);
        if (productId == 0)
            finish();

        //((MartApplication) getApplication()).getAppComponent().inject(this);
        mProductDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductDetailsViewModel.class);

        mImagePager = (ViewPager) findViewById(R.id.imagePager);
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        productTitle = (TextView) findViewById(R.id.productTitle);
        productDefTextView = (TextView) findViewById(R.id.productDefTextView);
        productWightTextView = (TextView) findViewById(R.id.productWightTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        originalPriceTextView = (TextView) findViewById(R.id.originalPriceTextView);
        aboutProductTextView = (TextView) findViewById(R.id.aboutProductTextView);

        if (!Util.isNetworkConnected(this)) {
            Toast.makeText(this, "Please check internet connection.",
                    Toast.LENGTH_LONG).show();
            finish();
        } else {
            mProductDetailsViewModel.getProductDetails(productId);
            mProductDetailsViewModel.getProductInfo().observe(this, new Observer<ProductInfo>() {
                @Override
                public void onChanged(@Nullable ProductInfo productInfo) {
                    displayProduct(productInfo.getProduct());
                }
            });
        }
    }


    public void displayProduct(Product product) {
        this.selectedProduct = product;

        productTitle.setText(selectedProduct.getTitle());
        productDefTextView.setText(selectedProduct.getDetails().getStorage_class());
        productWightTextView.setText(selectedProduct.getMeasure().getWt_or_vol());
        aboutProductTextView.setText(selectedProduct.getDesc());

        if(product.getPricing().getPromo_price()!=0) {
            originalPriceTextView.setText("$" + String.format("%.2f", product.getPricing().getPrice()));
            priceTextView.setText("$" + String.format("%.2f", product.getPricing().getPromo_price()));
        }else{
            originalPriceTextView.setVisibility(View.GONE);
            priceTextView.setText("$" + String.format("%.2f", product.getPricing().getPrice()));
        }

        mImagePager.setAdapter(new ImageSlideAdapter(this, selectedProduct.getImages()));

        mIndicator.setViewPager(mImagePager);
    }

    public void showError(String message) {
        Toast.makeText(this, "Please check internet connection.",
                Toast.LENGTH_LONG).show();
        finish();
    }
}
