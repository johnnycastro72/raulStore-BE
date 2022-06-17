package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateReceiptNote {
    Mono<ReceiptNoteDTO> apply(ReceiptNoteDTO receiptNoteDTO);
}
