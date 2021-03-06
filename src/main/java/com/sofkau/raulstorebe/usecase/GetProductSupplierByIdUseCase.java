package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetProductSupplierByIdUseCase implements Function<String, Mono<ProductSupplierDTO>> {

    private final IProductSupplierRepository iProductSupplierRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductSupplierDTO> apply(String id) {
        return iProductSupplierRepository.findById(id)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getStackTrace());
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(() -> new NoSuchElementException()))
                .map(productSupplier -> storeMapper.toProductSupplierDTO().apply(productSupplier));
    }
}
