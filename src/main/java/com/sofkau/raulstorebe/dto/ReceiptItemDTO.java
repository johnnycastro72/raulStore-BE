package com.sofkau.raulstorebe.dto;

import java.util.Objects;

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

    public String productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public void changeProductName(String productName) {
        this.productName = productName;
    }

    public Integer quantity() {
        return quantity;
    }

    public void updateQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer productUnits() {
        return productUnits;
    }

    public void changeProductUnits(Integer productUnits) {
        this.productUnits = productUnits;
    }

    public Integer maximumUnits() {
        return maximumUnits;
    }

    public void changeMaximumUnits(Integer maximumUnits) {
        this.maximumUnits = maximumUnits;
    }

    @Override
    public String toString() {
        return "ReceiptItemDTO{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", productUnits=" + productUnits +
                ", maximumUnits=" + maximumUnits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItemDTO that = (ReceiptItemDTO) o;
        return productId.equals(that.productId) && productName.equals(that.productName) && quantity.equals(that.quantity) && productUnits.equals(that.productUnits) && maximumUnits.equals(that.maximumUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity, productUnits, maximumUnits);
    }
}
