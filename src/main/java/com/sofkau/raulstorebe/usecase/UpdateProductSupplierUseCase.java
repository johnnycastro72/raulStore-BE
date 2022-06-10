package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IUpdateProductSupplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateProductSupplierUseCase implements IUpdateProductSupplier {

    private final IProductSupplierRepository iProductSupplierRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductSupplierDTO> apply(String id, ProductSupplierDTO productSupplierDTO) {
        return iProductSupplierRepository.findById(id)
                .flatMap(productSupplier -> {
                    productSupplierDTO.setId(productSupplier.getId());
                    return iProductSupplierRepository.save(storeMapper.toProductSupplier().apply(productSupplierDTO))
                            .map(productSupplier1 -> storeMapper.toProductSupplierDTO().apply(productSupplier1));
                }).switchIfEmpty(Mono.just(new ProductSupplierDTO()));
    }
}
