package com.sofkau.raulstorebe.repository;

import com.sofkau.raulstorebe.collection.ReceiptNote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IReceiptNoteRepository extends ReactiveMongoRepository<ReceiptNote, String> {
    Mono<ReceiptNote> findByReceiptNumber(String receiptNumber);
}
