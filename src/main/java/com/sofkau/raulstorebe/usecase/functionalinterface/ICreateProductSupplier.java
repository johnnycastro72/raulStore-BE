package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateProductSupplier {
    Mono<ProductSupplierDTO> apply (ProductSupplierDTO productSupplierDTO);
}
