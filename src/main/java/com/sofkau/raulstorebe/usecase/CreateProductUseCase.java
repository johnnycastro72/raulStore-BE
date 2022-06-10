package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Validated(ProductDTO.class)
public class CreateProductUseCase implements ICreateProduct {

    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductDTO> apply(@Valid ProductDTO productDTO) {
        return iProductRepository
                .save(storeMapper.toProduct()
                .apply(productDTO)).map(product -> storeMapper
                        .toProductDTO().apply(product));
    }
}
