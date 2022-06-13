package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class GetProductSupplierByIdUseCaseTest {

    @SpyBean
    private GetProductSupplierByIdUseCase getProductSupplierByIdUseCase;

    @MockBean
    private IProductSupplierRepository iProductSupplierRepository;

    @Test
    @DisplayName("Get a Product Supplier By Id Use Case Test")
    void getProductSupplierByIdUseCaseTest() {
        ProductSupplierDTO productSupplierDTO = new ProductSupplierDTO();
        productSupplierDTO.setId("0001");
        productSupplierDTO.setTaxPayerId("88188199");
        productSupplierDTO.setSupplierName("Pedro Valencia");
        productSupplierDTO.setSupplierPhone("333-3332221");
        productSupplierDTO.setSupplierNotes("");

        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setId(productSupplierDTO.getId());
        productSupplier.setTaxPayerId(productSupplierDTO.getTaxPayerId());
        productSupplier.setSupplierName(productSupplierDTO.getSupplierName());
        productSupplier.setSupplierPhone(productSupplierDTO.getSupplierPhone());
        productSupplier.setSupplierNotes(productSupplierDTO.getSupplierNotes());

        Mockito.when(iProductSupplierRepository.findById(productSupplierDTO.getId()))
                .thenReturn(Mono.just(productSupplier));

        var resultMono = getProductSupplierByIdUseCase.apply("0001");

        StepVerifier
                .create(resultMono)
                .expectNext(productSupplierDTO)
                .verifyComplete();
    }

}