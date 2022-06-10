package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetProductsByUnitsGreaterThanUseCase implements Function<Integer, Flux<ProductDTO>> {
    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;

    @Override
    public Flux<ProductDTO> apply(Integer units) {
        return iProductRepository
                .findProductsByUnitsIsGreaterThan(units)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getStackTrace());
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(() -> new NoSuchElementException()))
                .map(product -> storeMapper.toProductDTO().apply(product));
    }
}
