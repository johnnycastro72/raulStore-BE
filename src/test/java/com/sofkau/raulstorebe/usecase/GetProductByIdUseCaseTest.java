package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.collection.Product;
import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.repository.IProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
class GetProductByIdUseCaseTest {

    @SpyBean
    private GetProductByIdUseCase getProductByIdUseCase;

    @MockBean
    private IProductRepository iProductRepository;

    @Test
    @DisplayName("Get a Product By Id Use Case Test")
    void GetProductByIdUseCaseTest() {
        ProductSupplierDTO productSupplierDTO = new ProductSupplierDTO();
        productSupplierDTO.setId("01");
        productSupplierDTO.setTaxPayerId("88188199");
        productSupplierDTO.setSupplierName("Pedro Valencia");
        productSupplierDTO.setSupplierPhone("333-3332221");
        productSupplierDTO.setSupplierNotes("");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("0001");
        productDTO.setName("Nuts 1/2");
        productDTO.setDescription("stainless steel half-inch nuts");
        productDTO.setUnits(0);
        productDTO.setMinimumUnits(10);
        productDTO.setMaximumUnits(500);
        productDTO.setPrice(0.5);
        productDTO.setProductSupplierDTO(productSupplierDTO);

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setUnits(productDTO.getUnits());
        product.setMinimumUnits(productDTO.getMinimumUnits());
        product.setMaximumUnits(productDTO.getMaximumUnits());
        product.setPrice(productDTO.getPrice());
        product.setProductSupplierDTO(productSupplierDTO);

        Mockito.when(iProductRepository.findById(productDTO.getId()))
                .thenReturn(Mono.just(product));

        var resultMono = getProductByIdUseCase.apply("0001");

        StepVerifier
                .create(resultMono)
                .expectNext(productDTO)
                .verifyComplete();
    }
}