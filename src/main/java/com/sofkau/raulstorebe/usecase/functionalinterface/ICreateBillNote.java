package com.sofkau.raulstorebe.usecase.functionalinterface;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateBillNote {
    Mono<BillNoteDTO> apply(BillNoteDTO billNoteDTO);
}
