package com.sofkau.raulstorebe.collection;

import lombok.Data;

import java.util.Objects;

@Data
public class ReceiptItem {
    private String productId;
    private String productName;
    private Integer quantity;

    private Integer productUnits;

    private Integer maximumUnits;

    public ReceiptItem(String productId, String productName, Integer quantity, Integer productUnits, Integer maximumUnits) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.productUnits = productUnits;
        this.maximumUnits = maximumUnits;
    }

    public ReceiptItem() {
    }
}

