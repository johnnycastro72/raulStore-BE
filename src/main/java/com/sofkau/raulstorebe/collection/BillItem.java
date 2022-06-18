package com.sofkau.raulstorebe.collection;

import lombok.Data;

@Data
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
}
