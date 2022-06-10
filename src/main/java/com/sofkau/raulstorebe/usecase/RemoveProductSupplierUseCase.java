package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IRemoveProductSupplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RemoveProductSupplierUseCase implements IRemoveProductSupplier {

    private final IProductSupplierRepository iSupplierRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<Void> apply(String id) {
        return null;
    }
}
