package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateProductSupplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CreateProductSupplierUseCase implements ICreateProductSupplier {

    private final IProductSupplierRepository iProductSupplierRepository;

    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductSupplierDTO> apply(ProductSupplierDTO productSupplierDTO) {
        return iProductSupplierRepository
                .save(storeMapper.toProductSupplier()
                        .apply(productSupplierDTO)).map(productSupplier -> storeMapper
                        .toProductSupplierDTO().apply(productSupplier));
    }
}
