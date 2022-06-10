package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
public class GetProductSupplierByIdUseCase implements Function<String, Mono<ProductSupplierDTO>> {

    private IProductSupplierRepository iProductSupplierRepository;
    private StoreMapper storeMapper;

    public GetProductSupplierByIdUseCase(IProductSupplierRepository iProductSupplierRepository, StoreMapper storeMapper) {
        this.iProductSupplierRepository = iProductSupplierRepository;
        this.storeMapper = storeMapper;
    }

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
