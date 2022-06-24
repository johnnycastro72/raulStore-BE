package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.dto.ProductSupplierDTO;
import com.sofkau.raulstorebe.usecase.GetProductsByProductSupplierIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductsByProductSupplierRoute {

    @Bean
    @RouterOperation(

            operation = @Operation(
                    description = "Get All Products By Product Supplier",
                    operationId = "getProductsByProductSupplierRouter",
                    tags = {"Product"},
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
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id")}
            )
    )
    public RouterFunction<ServerResponse> getProductsByProductSupplierRouter(GetProductsByProductSupplierIdUseCase getProductsByProductSupplierIdUseCase) {
        return route(GET("/api/v1/product/productsupplier/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getProductsByProductSupplierIdUseCase
                                .apply(request.pathVariable("id")), ProductDTO.class)));
    }

}
