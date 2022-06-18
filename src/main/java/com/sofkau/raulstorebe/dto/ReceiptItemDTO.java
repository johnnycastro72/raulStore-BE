package com.sofkau.raulstorebe.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class ReceiptItemDTO {
    private String productId;
    private String productName;
    private Integer quantity;

    private Integer productUnits;

    private Integer maximumUnits;

    public ReceiptItemDTO(String productId, String productName, Integer quantity, Integer productUnits, Integer maximumUnits) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.productUnits = productUnits;
        this.maximumUnits = maximumUnits;
    }

    public ReceiptItemDTO() {
    }

}
