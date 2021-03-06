package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.usecase.CreateProductSupplierUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProductSupplierRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    description = "Create a Product Supplier",
                    operationId = "createProductSupplierRouter",
                    tags = {"Product Supplier"},
                    responses = {@ApiResponse(
                            responseCode = "201",
                            description = "Product supplier successfully created",
                            content = @Content(schema = @Schema(
                                    implementation = ProductSupplierDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Product Supplier details supplied"
                    )}, requestBody = @RequestBody(
                    content = @Content(schema = @Schema(
                            implementation = ProductSupplierDTO.class
                    ))
            ))
    )
    public RouterFunction<ServerResponse> createProductSupplierRouter(CreateProductSupplierUseCase createProductSupplierUseCase) {

        Function<ProductSupplierDTO, Mono<ServerResponse>> executeCreate = productSupplierDTO -> createProductSupplierUseCase.apply(productSupplierDTO)
                .flatMap(productSupplierDTO1 -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(productSupplierDTO1));

        return route(POST("/api/v1/create/productsupplier")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProductSupplierDTO.class)
                .flatMap(executeCreate));
    }
}
