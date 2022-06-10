package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service

public class CreateSupplierUseCase implements ICreateSupplier {
    @Autowired
    private IProductSupplierRepository iProductSupplierRepository;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Mono<ProductSupplierDTO> apply(ProductSupplierDTO productSupplierDTO) {
        return iProductSupplierRepository
                .save(storeMapper.toProductSupplier()
                        .apply(productSupplierDTO)).map(productSupplier -> storeMapper
                        .toProductSupplierDTO().apply(productSupplier));
    }
}
