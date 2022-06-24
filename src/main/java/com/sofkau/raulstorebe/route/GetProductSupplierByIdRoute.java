package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.usecase.GetProductSupplierByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductSupplierByIdRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "getProductSupplierByIdRouter",
                    tags = {"Product Supplier"},
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(schema = @Schema(
                                    implementation = ProductSupplierDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "404",
                            description = "Product Supplier ID not found"
                    )},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id")}
            )
    )
    public RouterFunction<ServerResponse> getProductSupplierByIdRouter(GetProductSupplierByIdUseCase getProductSupplierByIdUseCase) {
        return route(GET("/api/v1/productsupplier/{id}"),
                request -> {
                    return getProductSupplierByIdUseCase.apply(request.pathVariable("id"))
                            .onErrorResume(throwable -> Mono.empty())
                            .flatMap(productSupplierDTO -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(productSupplierDTO))
                            .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).build());
                });
    }

}