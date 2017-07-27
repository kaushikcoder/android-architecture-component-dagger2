
package com.kaushik.myredmart.model.details;


public class ProductInfo {

    private int total;
    private Product product;
    private Status status;

    public  void setter(int total, Product product, Status status){
        this.total = total;
        this.product = product;
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
