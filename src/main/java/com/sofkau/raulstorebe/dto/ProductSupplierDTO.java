package com.sofkau.raulstorebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSupplierDTO {
    private String id;

    @NotBlank(message = "Supplier tax payer Id can't be blank")
    private String taxPayerId;

    @NotBlank(message = "Supplier name can't be blank")
    private String supplierName;

    @NotBlank(message = "Supplier phone can't be blank")
    private String supplierPhone;

    private String supplierNotes;

}
