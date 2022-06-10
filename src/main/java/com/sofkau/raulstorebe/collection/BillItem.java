package com.sofkau.raulstorebe.collection;

import java.util.Objects;

public class BillItem {
    private String productId;
    private String productName;
    private Integer billQuantity;
    private Double productPrice;

    private Integer productUnits;

    private Integer productMinimumUnits;

    public BillItem(String productId, String productName, Integer billQuantity, Double productPrice, Integer productUnits, Integer productMinimumUnits) {
        this.productId = productId;
        this.productName = productName;
        this.billQuantity = billQuantity;
        this.productPrice = productPrice;
        this.productUnits = productUnits;
        this.productMinimumUnits = productMinimumUnits;
    }

    public BillItem() {
    }

    public String productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public void changeProductName(String productName) {
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

    public Integer productUnits() {
        return productUnits;
    }

    public void changeProductUnits(Integer productUnits) {
        this.productUnits = productUnits;
    }

    public Integer productMinimumUnits() {
        return productMinimumUnits;
    }

    public void changeProductMinimumUnits(Integer productMinimumUnits) {
        this.productMinimumUnits = productMinimumUnits;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", billQuantity=" + billQuantity +
                ", productPrice=" + productPrice +
                ", productUnits=" + productUnits +
                ", productMinimumUnits=" + productMinimumUnits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return productId.equals(billItem.productId) && productName.equals(billItem.productName) && billQuantity.equals(billItem.billQuantity) && productPrice.equals(billItem.productPrice) && productUnits.equals(billItem.productUnits) && productMinimumUnits.equals(billItem.productMinimumUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, billQuantity, productPrice, productUnits, productMinimumUnits);
    }
}
