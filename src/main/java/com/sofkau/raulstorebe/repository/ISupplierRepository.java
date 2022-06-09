package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ISupplierRepository extends ReactiveMongoRepository<Supplier, String> {
    Mono<Supplier> findBySupplierName(String supplierName);
}
