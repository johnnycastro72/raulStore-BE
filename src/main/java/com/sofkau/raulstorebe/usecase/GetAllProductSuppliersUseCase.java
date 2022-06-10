package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProductSuppliersUseCase implements Supplier<Flux<ProductSupplierDTO>> {

    private final IProductSupplierRepository iProductSupplierRepository;
    private final StoreMapper storeMapper;

    @Override
    public Flux<ProductSupplierDTO> get() {
        return iProductSupplierRepository.findAll()
                .map(productSupplier -> storeMapper.toProductSupplierDTO().apply(productSupplier));
    }
}
