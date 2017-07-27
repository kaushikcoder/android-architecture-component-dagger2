
package com.kaushik.myredmart.model.details;


public class Pricing {

    private int promo_id;
    private int on_sale;
    private double price;
    private double promo_price;
    private double savings;
    private double savings_amount;

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public int getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(int on_sale) {
        this.on_sale = on_sale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromo_price() {
        return promo_price;
    }

    public void setPromo_price(double promo_price) {
        this.promo_price = promo_price;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getSavings_amount() {
        return savings_amount;
    }

    public void setSavings_amount(double savings_amount) {
        this.savings_amount = savings_amount;
    }

}
