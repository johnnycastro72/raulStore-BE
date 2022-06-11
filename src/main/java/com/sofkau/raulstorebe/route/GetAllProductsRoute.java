package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.usecase.GetAllProductsUseCase;
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

import java.awt.*;
import java.net.http.HttpResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "getAllProductsRouter",
                    tags = {"Get All Products"},
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Bad request response"
                    )}
            )
    )
    public RouterFunction<ServerResponse> getAllProductsRouter(GetAllProductsUseCase getAllProductsUseCase) {
        return route(GET("/api/v1/products"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductsUseCase.get(), ProductDTO.class)));
    }
}
