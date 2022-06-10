package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.ProductDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IUpdateProduct {
    Mono<ProductDTO> apply (String id, ProductDTO productDTO);

}
