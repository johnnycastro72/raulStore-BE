package com.sofkau.raulstorebe.dto;

import java.util.Objects;

public class ReceiptItemDTO {
    private String productId;
    private String productName;
    private Integer quantity;

    public ReceiptItemDTO(String productId, String productName, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "ReceiptItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItemDTO that = (ReceiptItemDTO) o;
        return productId.equals(that.productId) && productName.equals(that.productName) && quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity);
    }
}
