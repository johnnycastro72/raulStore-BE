package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.ProductDTO;
import reactor.core.publisher.Mono;

public interface ICreateProduct {
    Mono<ProductDTO> apply(ProductDTO productDTO);
}
