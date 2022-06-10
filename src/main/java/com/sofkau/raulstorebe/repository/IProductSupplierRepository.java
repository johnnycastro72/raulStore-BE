package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IProductSupplierRepository extends ReactiveMongoRepository<ProductSupplier, String> {
    Mono<ProductSupplier> findBySupplierName(String supplierName);
}
