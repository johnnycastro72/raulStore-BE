package com.sofkau.raulstorebe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productSuppliers")
public class ProductSupplier {
    @Id
    private String id;

    @NotBlank(message = "Supplier tax payer Id can't be blank")
    private String taxPayerId;

    @NotBlank(message = "Supplier name can't be blank")
    private String supplierName;

    @NotBlank(message = "Supplier phone can't be blank")
    private String supplierPhone;

    private String supplierNotes;
}
