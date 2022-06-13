package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.repository.IProductSupplierRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class RemoveProductSupplierUseCaseTest {

    @SpyBean
    private RemoveProductSupplierUseCase removeProductSupplierUseCase;

    @MockBean
    private IProductSupplierRepository iProductSupplierRepository;

    @Test
    @DisplayName("Remove ")

}