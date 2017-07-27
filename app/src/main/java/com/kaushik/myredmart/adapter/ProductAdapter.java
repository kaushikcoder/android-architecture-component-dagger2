package com.kaushik.myredmart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaushik.myredmart.ui.R;
import com.kaushik.myredmart.utility.Util;
import com.kaushik.myredmart.model.list.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kaushik on 18-04-2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final Context mContext;
    private List<Product> productList;

    public ProductAdapter(List<Product> productList, Context context) {
        mContext = context;
        this.productList = productList;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {

        if (productList.size() - 4 == position) {
            ((AdapterListener) mContext).getMoreProducts();
        }

        final Product product = productList.get(position);
        holder.productTitle.setText(product.getTitle());
        holder.productQuantity.setText(product.getMeasure().getWt_or_vol());
        if (product.getPricing().getPromo_price() != null && product.getPricing().getPromo_price() != 0) {
            holder.productOriginalPrice.setText("$" + String.format("%.2f", product.getPricing().getPrice()));
            holder.productPrice.setText("$" + String.format("%.2f", product.getPricing().getPromo_price()));
        } else {
            holder.productOriginalPrice.setVisibility(View.GONE);
            holder.productPrice.setText("$" + String.format("%.2f", product.getPricing().getPrice()));
        }

        if (product.getImg().getName() != null && !product.getImg().getName().equalsIgnoreCase(""))
            Picasso.with(mContext).load(Util.IMG_URL + product.getImg().getName()).into(holder.productImageView);

        holder.productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AdapterListener) mContext).showProductDetails(product.getId(), (View) holder.productImageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public Product getItemAtPosition(int position) {
        return productList.get(position);
    }

    public void updateProduct(List<Product> products) {
        productList = products;
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImageView;
        public TextView productTitle;
        public TextView productQuantity;
        public TextView productPrice;
        public TextView productOriginalPrice;

        public ProductViewHolder(View view) {
            super(view);

            productImageView = (ImageView) view.findViewById(R.id.productImageView);
            productTitle = (TextView) view.findViewById(R.id.productTitle);
            productQuantity = (TextView) view.findViewById(R.id.productQuantity);
            productPrice = (TextView) view.findViewById(R.id.productPrice);
            productOriginalPrice = (TextView) view.findViewById(R.id.productOriginalPrice);
        }
    }

    public interface AdapterListener {
        void getMoreProducts();

        void showProductDetails(Integer id, View productTitle);
    }
}
