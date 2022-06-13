package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ProductDTO;
import com.sofkau.raulstorebe.usecase.CreateProductUseCase;
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
public class CreateProductRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "createProductRouter",
                    tags = {"Create Product"},
                    responses = {@ApiResponse(
                            responseCode = "201",
                            description = "Product Successfully created",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Product details supplied"
                    )},
                    requestBody = @RequestBody(
                            required = true,
                            description = "Enter request body as JSON object",
                            content = @Content(schema = @Schema(
                                    implementation = ProductDTO.class
                            ))
                    )
            )
    )
    public RouterFunction<ServerResponse> createProductRouter(CreateProductUseCase createProductUseCase) {

        Function<ProductDTO, Mono<ServerResponse>> executeCreate = productDTO -> createProductUseCase.apply(productDTO)
                .flatMap(productDTO1 -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(productDTO1));

        return route(POST("/create/product")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProductDTO.class)
                .flatMap(executeCreate));
    }
}
