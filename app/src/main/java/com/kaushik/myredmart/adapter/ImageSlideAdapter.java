package com.kaushik.myredmart.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kaushik.myredmart.ui.R;
import com.kaushik.myredmart.model.details.Image;
import com.kaushik.myredmart.utility.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kaushik on 19-04-2017.
 */

public class ImageSlideAdapter extends PagerAdapter {


    private final Context mContext;
    private final List<Image> imageList;
    private final LayoutInflater mLayoutInflater;

    public ImageSlideAdapter(Context cont, List<Image> images) {
        mContext = cont;
        imageList = images;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_product_img, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.productImageView);

        if(!imageList.get(position).getName().equalsIgnoreCase(""))
            Picasso.with(mContext).load(Util.IMG_URL + imageList.get(position).getName()).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
