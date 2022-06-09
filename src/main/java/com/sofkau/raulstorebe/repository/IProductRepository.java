package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.Product;
import com.sofkau.raulstorebe.collection.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
    Mono<Product> findByName(String Name);
    Flux<Product> findProductsBySupplier(Supplier supplier);
    Flux<Product> findProductsByUnitsIsLessThanEqualAndMinimumUnits();
    Flux<Product> findProductsByMaximumUnitsIsGreaterThanAndMaximumUnits();
}
