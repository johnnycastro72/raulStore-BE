package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IRemoveProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RemoveProductUseCase implements IRemoveProduct {

    private final IProductRepository iProductRepository;

    @Override
    public Mono<Void> apply(String id) {
        return iProductRepository.deleteById(id);
    }
}
