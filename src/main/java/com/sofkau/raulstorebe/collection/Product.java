package com.sofkau.raulstorebe.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @NotBlank(message = "Product name can't be blank")
    private String name;

    @NotBlank(message = "Product description can't be blank")
    private String description;

    private Integer units;

    private Double price;

    private Integer minimumUnits;

    private Integer maximumUnits;

    private Supplier supplier;
}
