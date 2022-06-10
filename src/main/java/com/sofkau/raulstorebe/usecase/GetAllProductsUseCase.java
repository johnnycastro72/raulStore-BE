package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProductsUseCase implements Supplier<Flux<ProductDTO>> {
    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;


    @Override
    public Flux<ProductDTO> get() {
        return iProductRepository.findAll()
                .map(product -> storeMapper.toProductDTO().apply(product));
    }
}
