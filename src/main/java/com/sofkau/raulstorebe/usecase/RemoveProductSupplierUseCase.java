package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IRemoveProductSupplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RemoveProductSupplierUseCase implements IRemoveProductSupplier {

    private final IProductSupplierRepository iProductSupplierRepository;

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "id can't be null");
        return iProductSupplierRepository.deleteById(id);
    }
}
