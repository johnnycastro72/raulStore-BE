package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.SupplierDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateSupplier {
    Mono<SupplierDTO> apply (SupplierDTO supplierDTO);
}
