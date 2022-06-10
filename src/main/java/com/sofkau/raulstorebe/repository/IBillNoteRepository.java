package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.BillNote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBillNoteRepository extends ReactiveMongoRepository<BillNote, String> {
    Mono<BillNote> findByBillId(String billId);
}
