package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import com.sofkau.raulstorebe.usecase.CreateReceiptNoteUseCase;
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
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateReceiptNoteRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    operationId = "createReceiptNoteRouter",
                    tags = {"Create Receipt Note"},
                    responses = {@ApiResponse(
                            responseCode = "201",
                            description = "Receipt Note Successfully created",
                            content = @Content(schema = @Schema(
                                    implementation = ReceiptNoteDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Receipt Note details supplied"
                    )},
                    requestBody = @RequestBody(
                            required = true,
                            description = "Enter request body as JSON object",
                            content = @Content(schema = @Schema(
                                    implementation = ReceiptNoteDTO.class
                            ))
                    )
            )
    )
    public RouterFunction<ServerResponse> createReceiptNoteRouter(CreateReceiptNoteUseCase createReceiptNoteUseCase) {

        Function<ReceiptNoteDTO, Mono<ServerResponse>> executeCreate = receiptNoteDTO -> createReceiptNoteUseCase.apply(receiptNoteDTO)
                .flatMap(receiptNoteDTO1 -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(receiptNoteDTO1));

        return route(POST("/api/v1/create/receiptnote")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ReceiptNoteDTO.class)
                .flatMap(executeCreate));
    }
}
