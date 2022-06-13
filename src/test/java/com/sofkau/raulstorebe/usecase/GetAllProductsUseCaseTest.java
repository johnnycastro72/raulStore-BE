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
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProductsUseCaseTest {

    @SpyBean
    private GetAllProductsUseCase getAllProductsUseCase;

    @MockBean
    private IProductRepository iProductRepository;

    @Test
    @DisplayName("Get All Products Use Case Test")
    void getAllProductsUseCaseTest() {
        ProductSupplierDTO productSupplierDTO1 = new ProductSupplierDTO();
        productSupplierDTO1.setId("01");
        productSupplierDTO1.setTaxPayerId("88188199");
        productSupplierDTO1.setSupplierName("Pedro Valencia");
        productSupplierDTO1.setSupplierPhone("333-3332221");
        productSupplierDTO1.setSupplierNotes("");
        ProductSupplierDTO productSupplierDTO2 = new ProductSupplierDTO();
        productSupplierDTO2.setId("02");
        productSupplierDTO2.setTaxPayerId("89198189");
        productSupplierDTO2.setSupplierName("Mario Caceres");
        productSupplierDTO2.setSupplierPhone("322-3113321");
        productSupplierDTO2.setSupplierNotes("");

        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setId("0001");
        productDTO1.setName("Nuts 1/2");
        productDTO1.setDescription("stainless steel half-inch nuts");
        productDTO1.setUnits(0);
        productDTO1.setMinimumUnits(10);
        productDTO1.setMaximumUnits(500);
        productDTO1.setPrice(0.5);
        productDTO1.setProductSupplierDTO(productSupplierDTO1);
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setId("0002");
        productDTO2.setName("bolts 10mm");
        productDTO2.setDescription("stainless steel ten millimeters nuts");
        productDTO2.setUnits(0);
        productDTO2.setMinimumUnits(100);
        productDTO2.setMaximumUnits(500);
        productDTO2.setPrice(0.4);
        productDTO2.setProductSupplierDTO(productSupplierDTO2);

        Product product1 = new Product();
        product1.setId(productDTO1.getId());
        product1.setName(productDTO1.getName());
        product1.setDescription(productDTO1.getDescription());
        product1.setUnits(productDTO1.getUnits());
        product1.setMinimumUnits(productDTO1.getMinimumUnits());
        product1.setMaximumUnits(productDTO1.getMaximumUnits());
        product1.setPrice(productDTO1.getPrice());
        product1.setProductSupplierDTO(productSupplierDTO1);
        Product product2 = new Product();
        product2.setId(productDTO2.getId());
        product2.setName(productDTO2.getName());
        product2.setDescription(productDTO2.getDescription());
        product2.setUnits(productDTO2.getUnits());
        product2.setMinimumUnits(productDTO2.getMinimumUnits());
        product2.setMaximumUnits(productDTO2.getMaximumUnits());
        product2.setPrice(productDTO2.getPrice());
        product2.setProductSupplierDTO(productSupplierDTO2);

        Mockito.when(iProductRepository.findAll())
                .thenReturn(Flux.just(product1, product2));

        Flux<ProductDTO> publisher = getAllProductsUseCase.get();

        StepVerifier
                .create(publisher)
                .expectNext(productDTO1)
                .expectNext(productDTO2)
                .verifyComplete();
    }

}