package com.kaushik.myredmart.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import android.widget.TextView;
import android.widget.Toast;

import com.kaushik.myredmart.MartApplication;
import com.kaushik.myredmart.adapter.ProductAdapter;
import com.kaushik.myredmart.di.Injectable;
import com.kaushik.myredmart.model.list.Product;
import com.kaushik.myredmart.viewmodel.ProductListViewModel;
import com.kaushik.myredmart.utility.Util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProductListActivity extends LifecycleActivity implements ProductAdapter.AdapterListener, Injectable {

    RecyclerView productListView;
    private ProductListViewModel mProductListViewModel;
    private ArrayList<Product> productList;
    private StaggeredGridLayoutManager mLayoutManager;
    private ProductAdapter mProductAdapter;
    private int pageNumber = 0;
    private TextView noProductTextView;
    private ProgressBar progressBar;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        productListView = (RecyclerView) findViewById(R.id.productListView);
        noProductTextView = (TextView) findViewById(R.id.noProductTextView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //((MartApplication) getApplication()).getAppComponent().inject(this);
        if(viewModelFactory==null)
            Log.d("viewModelFactory", "It is null");
        mProductListViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductListViewModel.class);

        productList = new ArrayList<Product>();

        if (!Util.isNetworkConnected(this)) {
            Toast.makeText(this, "Please check internet connection.",
                    Toast.LENGTH_LONG).show();
            finish();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            mProductListViewModel.getProductList().observe(this, new Observer<List<Product>>() {
                @Override
                public void onChanged(@Nullable List<Product> productList) {
                    displayProducts(productList);
                }
            });
            mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            productListView.setLayoutManager(mLayoutManager);
            mProductAdapter = new ProductAdapter(productList, this);
            productListView.setAdapter(mProductAdapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void displayProducts(List<Product> products) {
        progressBar.setVisibility(View.GONE);
        if (products.size() == 0) {
            noProductTextView.setVisibility(View.VISIBLE);
        } else {
            mProductAdapter.updateProduct(products);
            noProductTextView.setVisibility(View.GONE);
            productListView.setVisibility(View.VISIBLE);
        }
    }


    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void getMoreProducts() {
        mProductListViewModel.getProductListMore();
    }

    @Override
    public void showProductDetails(Integer productId, View view) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(Util.ProductId, productId);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, view, "product_img");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
