package com.sofkau.raulstorebe.collection;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

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

    private Integer units;

    private Double price;

    private Integer minimumUnits;

    private Integer maximumUnits;

    private ProductSupplierDTO productSupplierDTO;
}
