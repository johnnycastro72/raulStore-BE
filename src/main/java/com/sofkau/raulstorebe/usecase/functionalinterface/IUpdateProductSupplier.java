package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IUpdateProductSupplier {
    Mono<ProductSupplierDTO> apply (String id, ProductSupplierDTO productSupplierDTO);
}
