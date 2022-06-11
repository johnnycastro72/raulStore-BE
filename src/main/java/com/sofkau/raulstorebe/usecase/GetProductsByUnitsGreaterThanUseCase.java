package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetProductsByUnitsGreaterThanUseCase implements Function<String, Flux<ProductDTO>> {

    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;

    @Override
    public Flux<ProductDTO> apply(String units) {
        return iProductRepository
                .findProductsByUnitsIsGreaterThan(Integer.valueOf(units))
                .onErrorResume(throwable -> {
                    System.out.println(Arrays.toString(throwable.getStackTrace()));
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(NoSuchElementException::new))
                .map(product -> storeMapper.toProductDTO().apply(product));
    }
}
