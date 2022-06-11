package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.usecase.UpdateProductUseCase;
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
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {
    @Bean
    @RouterOperation(
            operation = @Operation(
                    operationId = "updateProductRouter",
                    tags = {"Update Product"},
                    responses = {@ApiResponse(
                            responseCode = "201",
                            description = "Product successfully updated",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "404",
                            description = "Product not found"
                    )},
                    parameters = @Parameter(in = ParameterIn.PATH, name = "id")
            )
    )
    public RouterFunction<ServerResponse> updateProductRouter(UpdateProductUseCase updateProductUseCase) {
        return route(PUT("/update/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(productDTO -> updateProductUseCase
                                .apply(request.pathVariable("id"), productDTO))
                        .flatMap(result -> result.getName() != null
                        ? ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                                : ServerResponse.status(HttpStatus.NOT_FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)));
    }
}
