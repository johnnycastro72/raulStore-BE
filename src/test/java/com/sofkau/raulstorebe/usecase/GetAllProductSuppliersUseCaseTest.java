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
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProductSuppliersUseCaseTest {

    @SpyBean
    private GetAllProductSuppliersUseCase getAllProductSuppliersUseCase;

    @MockBean
    private IProductSupplierRepository iProductSupplierRepository;

    @Test
    @DisplayName("Get All Product Suppliers Use Case Test")
    void getAllProductSuppliersUseCaseTest() {
        ProductSupplierDTO productSupplierDTO1 = new ProductSupplierDTO();
        productSupplierDTO1.setId("0001");
        productSupplierDTO1.setTaxPayerId("88188199");
        productSupplierDTO1.setSupplierName("Pedro Valencia");
        productSupplierDTO1.setSupplierPhone("333-3332221");
        productSupplierDTO1.setSupplierNotes("");
        ProductSupplierDTO productSupplierDTO2 = new ProductSupplierDTO();
        productSupplierDTO2.setId("0002");
        productSupplierDTO2.setTaxPayerId("89198189");
        productSupplierDTO2.setSupplierName("Mario Caceres");
        productSupplierDTO2.setSupplierPhone("322-3113321");
        productSupplierDTO2.setSupplierNotes("");

        ProductSupplier productSupplier1 = new ProductSupplier();
        productSupplier1.setId(productSupplierDTO1.getId());
        productSupplier1.setTaxPayerId(productSupplierDTO1.getTaxPayerId());
        productSupplier1.setSupplierName(productSupplierDTO1.getSupplierName());
        productSupplier1.setSupplierPhone(productSupplierDTO1.getSupplierPhone());
        productSupplier1.setSupplierNotes(productSupplierDTO1.getSupplierNotes());
        ProductSupplier productSupplier2 = new ProductSupplier();
        productSupplier2.setId(productSupplierDTO2.getId());
        productSupplier2.setTaxPayerId(productSupplierDTO2.getTaxPayerId());
        productSupplier2.setSupplierName(productSupplierDTO2.getSupplierName());
        productSupplier2.setSupplierPhone(productSupplierDTO2.getSupplierPhone());
        productSupplier2.setSupplierNotes(productSupplierDTO2.getSupplierNotes());

        Mockito.when(iProductSupplierRepository.findAll())
                .thenReturn(Flux.just(productSupplier1, productSupplier2));

        Flux<ProductSupplierDTO> publisher = getAllProductSuppliersUseCase.get();

        StepVerifier
                .create(publisher)
                .expectNext(productSupplierDTO1)
                .expectNext(productSupplierDTO2)
                .verifyComplete();
    }
}