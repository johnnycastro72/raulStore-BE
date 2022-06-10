package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.usecase.GetAllProductSuppliersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductSuppliersRoute {
    @Bean
    @RouterOperation(
            path = "/api/v1/productsuppliers",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.GET,
            beanClass = GetAllProductSuppliersUseCase.class,
            beanMethod = "get",

            operation = @Operation(
                    operationId = "getAllProductSuppliersRouter",
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(schema = @Schema(
                                    implementation = ProductSupplierDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Bad request response"
                    )}
            )
    )
    public RouterFunction<ServerResponse> getAllProductSuppliersRouter(GetAllProductSuppliersUseCase getAllProductSuppliersUseCase) {
        return route(GET("/api/v1/productsuppliers"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductSuppliersUseCase.get(), ProductSupplierDTO.class)));
    }
}
