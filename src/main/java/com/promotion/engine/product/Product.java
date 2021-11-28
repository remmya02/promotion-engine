package com.promotion.engine.product;

public class Product {

    private String productId;
    private int unitPrice;

    public Product(String productId, int unitPrice) {
        this.productId = productId;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
