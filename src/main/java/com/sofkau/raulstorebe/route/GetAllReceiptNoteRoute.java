package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import com.sofkau.raulstorebe.usecase.GetAllReceiptNotesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.swing.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllReceiptNoteRoute {
    @Bean
    @RouterOperation(
            operation = @Operation(
                    description = "Get All Receipt Notes",
                    operationId = "getAllReceiptNoteRouter",
                    tags = {"Receipt Note"},
                    responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Successful Operation",
                            content = @Content(schema = @Schema(
                                    implementation = ReceiptNoteDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Bad request response"
                    )}
            )
    )
    public RouterFunction<ServerResponse> getAllReceiptNotesRouter(GetAllReceiptNotesUseCase getAllReceiptNotesUseCase) {
        return route(GET("/api/v1/receiptnotes"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllReceiptNotesUseCase.get(), ReceiptNoteDTO.class)));
    }
}
