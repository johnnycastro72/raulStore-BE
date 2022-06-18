package com.sofkau.raulstorebe.dto;

import lombok.Data;

@Data
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

}
