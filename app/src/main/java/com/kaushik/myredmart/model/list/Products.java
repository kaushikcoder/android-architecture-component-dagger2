
package com.kaushik.myredmart.model.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {

    private List<Product> products = null;
    private Integer on_sale_count;
    private Integer total;
    private Integer page;
    private Integer pageSize;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getOn_sale_count() {
        return on_sale_count;
    }

    public void setOn_sale_count(Integer on_sale_count) {
        this.on_sale_count = on_sale_count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
