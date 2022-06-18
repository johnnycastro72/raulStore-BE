package com.sofkau.raulstorebe.collection;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
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
