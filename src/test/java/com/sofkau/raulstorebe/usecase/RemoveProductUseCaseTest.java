package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.collection.Product;
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
class RemoveProductUseCaseTest {
    @SpyBean
    private RemoveProductUseCase removeProductUseCase;

    @MockBean
    private IProductRepository iProductRepository;

    @Test
    @DisplayName("Remove a Product by Id Use Case Test")
    void RemoveProductUseCaseTest() {
        ProductSupplierDTO productSupplierDTO = new ProductSupplierDTO();
        productSupplierDTO.setId("01");
        productSupplierDTO.setTaxPayerId("88188199");
        productSupplierDTO.setSupplierName("Pedro Valencia");
        productSupplierDTO.setSupplierPhone("333-3332221");
        productSupplierDTO.setSupplierNotes("");

        Product product = new Product();
        product.setId("0001");
        product.setName("Nuts 1/2");
        product.setDescription("stainless steel half-inch nuts");
        product.setUnits(0);
        product.setMinimumUnits(10);
        product.setMaximumUnits(500);
        product.setPrice(0.5);
        product.setProductSupplierDTO(productSupplierDTO);

        Mockito.when(iProductRepository.deleteById(product.getId()))
                .thenReturn(Mono.empty());

        var resultMono = removeProductUseCase.apply("0001");

        StepVerifier
                .create(resultMono)
                .assertNext(unused -> unused.equals(null));
    }
}