package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.SupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.ISupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateSupplierUseCase implements ICreateSupplier {
    @Autowired
    private ISupplierRepository iSupplierRepository;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Mono<SupplierDTO> apply(SupplierDTO supplierDTO) {
        return iSupplierRepository
                .save(storeMapper.toSupplier()
                        .apply(supplierDTO)).map(supplier -> storeMapper.toSupplierDTO().apply(supplier));
    }
}
