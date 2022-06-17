package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.usecase.GetProductsByProductSupplierUseCase;
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

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductsByProductSupplierRoute {

    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "getProductsByProductSupplierRouter",
                    tags = {"Get All Products by Product Supplier"},
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Bad request response"
                    )},
                    requestBody = @RequestBody(
                            required = true,
                            description = "Enter request body as JSON object",
                            content = @Content(schema = @Schema(
                                    implementation = ProductSupplierDTO.class
                            ))
                    )
            )
    )
    public RouterFunction<ServerResponse> getProductsByProductSupplierRouter(GetProductsByProductSupplierUseCase getProductsByProductSupplierUseCase) {
        return route(GET("/api/v1/product/productsupplier"), request ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getProductsByProductSupplierUseCase.apply(request.bodyToMono(ProductSupplierDTO.class)), ProductDTO.class))
                        .onErrorResume(throwable -> Mono.empty())
                        .switchIfEmpty(ServerResponse.status(HttpStatus.NO_CONTENT).build())
        );
    }

}
