package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import com.sofkau.raulstorebe.usecase.GetBillByIdUseCase;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBillByIdRoute {
    @Bean
    @RouterOperation(
        operation = @Operation(
                operationId = "getBillByIdRouter",
                tags = {"Bill Note"},
                responses = {@ApiResponse(
                        responseCode = "200",
                        description = "Get Bill Note By Bill Id",
                        content = @Content(schema = @Schema(
                                implementation = BillNoteDTO.class
                        ))
                ), @ApiResponse(
                        responseCode = "400",
                        description = "Bill Note Id Not Found"
                )},
                parameters = {@Parameter(in = ParameterIn.PATH, name = "id")}
        )
    )
    public RouterFunction<ServerResponse> getBillByIdRouter(GetBillByIdUseCase getBillByIdUseCase) {
        return route(GET("api/v1/bill/{id}"),
                request -> {
                    return getBillByIdUseCase.apply(request.pathVariable("id"))
                            .onErrorResume(throwable -> Mono.empty())
                            .flatMap(billNoteDTO -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(billNoteDTO))
                            .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).build());
                });
    }
}
