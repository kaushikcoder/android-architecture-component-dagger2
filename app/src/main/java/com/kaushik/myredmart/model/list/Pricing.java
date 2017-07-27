
package com.kaushik.myredmart.model.list;

public class Pricing {

    private Double price;
    private Double promo_price;
    private Double savings;
    private Double savings_amount;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromo_price() {
        return promo_price;
    }

    public void setPromo_price(Double promo_price) {
        this.promo_price = promo_price;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Double getSavings_amount() {
        return savings_amount;
    }

    public void setSavings_amount(Double savings_amount) {
        this.savings_amount = savings_amount;
    }

}
