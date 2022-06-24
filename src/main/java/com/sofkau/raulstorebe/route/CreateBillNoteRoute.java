package com.sofkau.raulstorebe.route;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import com.sofkau.raulstorebe.usecase.CreateBillNoteUseCase;
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
public class CreateBillNoteRoute {
    @Bean
    @RouterOperation(

            operation = @Operation(
                    description = "Create a Bill Note",
                    operationId = "createBillNoteRouter",
                    tags = {"Bill Note"},
                    responses = {@ApiResponse(
                            responseCode = "201",
                            description = "Bill Note Successfully created",
                            content = @Content(schema = @Schema(
                                    implementation = BillNoteDTO.class
                            ))
                    ), @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Bill Note details supplied"
                    )},
                    requestBody = @RequestBody(
                            required = true,
                            description = "Enter request body as JSON object",
                            content = @Content(schema = @Schema(
                                    implementation = BillNoteDTO.class
                            ))
                    )
            )
    )
    public RouterFunction<ServerResponse> createBillNoteRouter(CreateBillNoteUseCase createBillNoteUseCase) {

        Function<BillNoteDTO, Mono<ServerResponse>> executeCreate = billNoteDTO -> createBillNoteUseCase.apply(billNoteDTO)
                .flatMap(billNoteDTO1 -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(billNoteDTO1));

        return route(POST("/api/v1/create/billnote")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(BillNoteDTO.class)
                .flatMap(executeCreate));
    }

}
