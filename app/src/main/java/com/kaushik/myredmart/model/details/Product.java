
package com.kaushik.myredmart.model.details;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String title;
    private String desc;
    private String sku;
    private Details details;
    private ProductLife product_life;
    private List<Image> images = new ArrayList<Image>();
    private Measure measure;
    private Pricing pricing;
    private List<Promotion> promotions = new ArrayList<Promotion>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public ProductLife getProduct_life() {
        return product_life;
    }

    public void setProduct_life(ProductLife product_life) {
        this.product_life = product_life;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

}
