package com.sofkau.raulstorebe.collection;

import java.util.Objects;

public class BillItem {
    private String productId;
    private String productName;
    private Integer billQuantity;
    private Double productPrice;

    public BillItem(String productId, String productName, Integer billQuantity, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.billQuantity = billQuantity;
        this.productPrice = productPrice;
    }

    public BillItem() {
    }

    public String productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer billQuantity() {
        return billQuantity;
    }

    public void changeBillQuantity(Integer billQuantity) {
        this.billQuantity = billQuantity;
    }

    public Double productPrice() {
        return productPrice;
    }

    public void changeProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", billQuantity=" + billQuantity +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return productId.equals(billItem.productId) && productName.equals(billItem.productName) && billQuantity.equals(billItem.billQuantity) && productPrice.equals(billItem.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, billQuantity, productPrice);
    }
}
