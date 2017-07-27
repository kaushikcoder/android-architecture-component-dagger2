
package com.kaushik.myredmart.model.details;


public class Promotion {

    private int id;
    private int type;
    private String savings_text;
    private String promo_label;
    private int current_product_group_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSavings_text() {
        return savings_text;
    }

    public void setSavings_text(String savings_text) {
        this.savings_text = savings_text;
    }

    public String getPromo_label() {
        return promo_label;
    }

    public void setPromo_label(String promo_label) {
        this.promo_label = promo_label;
    }

    public int getCurrent_product_group_id() {
        return current_product_group_id;
    }

    public void setCurrent_product_group_id(int current_product_group_id) {
        this.current_product_group_id = current_product_group_id;
    }

}
