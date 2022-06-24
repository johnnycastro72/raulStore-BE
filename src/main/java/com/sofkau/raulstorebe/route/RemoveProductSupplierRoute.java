package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.usecase.RemoveProductSupplierUseCase;
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
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RemoveProductSupplierRoute {
    @Bean
    @RouterOperation(
            operation = @Operation(
                    operationId = "removeProductSupplierRouter",
                    tags = {"Product Supplier"},
                    responses = {@ApiResponse(
                            responseCode = "202",
                            description = "Product supplier successfully removed"
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Product Supplier removal not complete"
                    )},
                    parameters = {@Parameter(in = ParameterIn.PATH, name="id")}
            )
    )
    public RouterFunction<ServerResponse> removeProductSupplierRouter(RemoveProductSupplierUseCase removeProductSupplierUseCase) {
        return route(DELETE("/api/v1/delete/productsupplier/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.ACCEPTED)
                        .body(BodyInserters
                                .fromPublisher(removeProductSupplierUseCase.apply(request.pathVariable("id")),Void.class)));
    }
}
