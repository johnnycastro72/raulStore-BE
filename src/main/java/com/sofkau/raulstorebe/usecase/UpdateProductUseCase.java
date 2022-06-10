package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IProductRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.IUpdateProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCase implements IUpdateProduct {

    private final IProductRepository iProductRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<ProductDTO> apply(String id, ProductDTO productDTO) {
        return iProductRepository.findById(id)
                .flatMap(product -> {
                    productDTO.setId(product.getId());
                    return iProductRepository.save(storeMapper.toProduct()
                                    .apply(productDTO))
                            .map(product1 -> storeMapper.toProductDTO().apply(product1));
                })
                .switchIfEmpty(Mono.just(new ProductDTO()));
    }
}
