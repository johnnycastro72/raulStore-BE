package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.collection.ProductSupplier;
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
class RemoveProductSupplierUseCaseTest {

    @SpyBean
    private RemoveProductSupplierUseCase removeProductSupplierUseCase;

    @MockBean
    private IProductSupplierRepository iProductSupplierRepository;

    @Test
    @DisplayName("Remove Product Supplier Use Case Test")
    void removeProductSupplierUseCaseTest() {
        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setId("0001");
        productSupplier.setTaxPayerId("88188199");
        productSupplier.setSupplierName("Pedro Valencia");
        productSupplier.setSupplierPhone("333-3332221");
        productSupplier.setSupplierNotes("");

        Mockito.when(iProductSupplierRepository.deleteById(productSupplier.getId()))
                .thenReturn(Mono.empty());

        var resultMono = removeProductSupplierUseCase.apply("0001");

        StepVerifier
                .create(resultMono)
                .assertNext(unused -> unused.equals(null));
    }

}