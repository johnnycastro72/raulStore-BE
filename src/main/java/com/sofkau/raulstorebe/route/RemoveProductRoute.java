package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.usecase.RemoveProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
public class RemoveProductRoute {
    @Bean
    @RouterOperation(
            operation = @Operation(
                    operationId = "removeProductRouter",
                    tags = {"Product"},
                    responses = {@ApiResponse(
                            responseCode = "202",
                            description = "Product successfully removed"
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Product removal not complete"
                    )},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id")}
            )
    )
    public RouterFunction<ServerResponse> removeProductRouter(RemoveProductUseCase removeProductUseCase) {
        return route(DELETE("/api/v1/delete/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.ACCEPTED)
                        .body(BodyInserters
                                .fromPublisher(removeProductUseCase.apply(request.pathVariable("id")), Void.class)));
    }
}
