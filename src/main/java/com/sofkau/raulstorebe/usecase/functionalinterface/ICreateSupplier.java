package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateSupplier {
    Mono<ProductSupplierDTO> apply (ProductSupplierDTO productSupplierDTO);
}
