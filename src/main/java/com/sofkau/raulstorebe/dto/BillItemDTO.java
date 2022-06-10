package com.sofkau.raulstorebe.dto;

import java.util.Objects;

public class BillItemDTO {
    private String productId;
    private String productName;
    private Integer billQuantity;
    private Double productPrice;

    private Integer productUnits;

    private Integer productMinimumUnits;

    public BillItemDTO(String productId, String productName, Integer billQuantity, Double productPrice, Integer productUnits, Integer productMinimumUnits) {
        this.productId = productId;
        this.productName = productName;
        this.billQuantity = billQuantity;
        this.productPrice = productPrice;
        this.productUnits = productUnits;
        this.productMinimumUnits = productMinimumUnits;
    }

    public BillItemDTO() {
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
        return "BillItemDTO{" +
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
        BillItemDTO that = (BillItemDTO) o;
        return productId.equals(that.productId) && productName.equals(that.productName) && billQuantity.equals(that.billQuantity) && productPrice.equals(that.productPrice) && productUnits.equals(that.productUnits) && productMinimumUnits.equals(that.productMinimumUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, billQuantity, productPrice, productUnits, productMinimumUnits);
    }
}
