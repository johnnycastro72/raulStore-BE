package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetProductByIdUseCase implements Function<String, Mono<ProductDTO>> {

    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductDTO> apply(String id) {
        return iProductRepository.findById(id)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getStackTrace());
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(() -> new NoSuchElementException()))
                .map(product -> storeMapper.toProductDTO().apply(product));
    }
}
