package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;

    @NotBlank(message = "Product name can't be blank")
    private String name;

    @NotBlank(message = "Product description can't be blank")
    private String description;

    private Integer units;

    private Double price;

    private Integer minimumUnits;

    private Integer maximumUnits;

    private ProductSupplierDTO productSupplierDTO;
}
