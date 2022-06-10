package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.Product;
import com.sofkau.raulstorebe.collection.ProductSupplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
    Mono<Product> findByName(String Name);
    Flux<Product> findProductsByProductSupplier(ProductSupplier productSupplier);
    Flux<Product> findProductsByUnitsIsLessThanEqualAndMinimumUnits();
    Flux<Product> findProductsByMaximumUnitsIsGreaterThanAndMaximumUnits();
    Flux<Product> findProductsByUnitsIsGreaterThan(Integer units);
}
