package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllProductSuppliersUseCase implements Supplier<Flux<ProductSupplierDTO>> {

    private IProductSupplierRepository iProductSupplierRepository;
    private StoreMapper storeMapper;

    @Override
    public Flux<ProductSupplierDTO> get() {
        return iProductSupplierRepository.findAll()
                .map(productSupplier -> storeMapper.toProductSupplierDTO().apply(productSupplier));
    }
}
