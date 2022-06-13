package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.usecase.GetProductsByUnitsGreaterThanUseCase;
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
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductsByUnitsGreaterThanRoute {
/*
    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "getProductsByUnitsGreaterThanRouter",
                    tags = {"Get products that are in stock"},
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Products in stock retrieved",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "404",
                            description = "Products in stock not found"
                    )},
                    parameters = {@Parameter(in = ParameterIn.PATH, name="stock")}
            )
    )
    public RouterFunction<ServerResponse> getProductsByUnitsGreaterThanRouter(GetProductsByUnitsGreaterThanUseCase getProductsByUnitsGreaterThanUseCase) {
        return route(GET("/api/vq/product/stock/{units}"),
                request -> {
            return getProductsByUnitsGreaterThanUseCase.apply(request.pathVariable("units"))
                    .onErrorResume(throwable -> Mono.empty())
                    .flatMap(productDTO -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(productDTO))
                    .switchIfEmpty(ServerResponse.status(HttpStatus.NO_CONTENT).build());
                });
    }
*/
}