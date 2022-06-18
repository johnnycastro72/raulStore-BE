package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;

    @NotBlank(message = "Product name can't be blank")
    private String name;

    @NotBlank(message = "Product description can't be blank")
    private String description;

    @Min(value=0, message="Product must have available units")
    private Integer units;

    @Digits(integer = 12, fraction = 2, message = "Price of the product must be a decimal value of 12 integers and 2 decimal places")
    private Double price;

    @PositiveOrZero(message="Products must have a minimum number of units greater or equal than zero")
    private Integer minimumUnits;

    @PositiveOrZero(message="Products must have a maximum number of units greater or equal than zero")
    private Integer maximumUnits;

    @NotEmpty
    private ProductSupplierDTO productSupplierDTO;
}
