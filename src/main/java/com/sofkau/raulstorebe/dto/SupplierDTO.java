package com.sofkau.raulstorebe.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SupplierDTO {
    private String id;

    @NotBlank(message = "Supplier tax payer Id can't be blank")
    private String taxPayerId;

    @NotBlank(message = "Supplier name can't be blank")
    private String supplierName;

    private String supplierPhone;

    private String supplierNotes;

}
