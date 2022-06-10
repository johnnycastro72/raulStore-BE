package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.ISupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IRemoveSupplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RemoveSupplierUseCase implements IRemoveSupplier {

    private final ISupplierRepository iSupplierRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<Void> apply(String id) {
        return null;
    }
}
