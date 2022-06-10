package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.Product;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
    Mono<Product> findByName(String Name);

    Flux<Product> findProductsByProductSupplierDTO(ProductSupplierDTO productSupplierDTO);

    Flux<Product> findProductsByUnitsIsLessThanEqualAndMinimumUnits();

    Flux<Product> findProductsByMaximumUnitsIsGreaterThanAndMaximumUnits();

    Flux<Product> findProductsByUnitsIsGreaterThan(Integer units);
}
