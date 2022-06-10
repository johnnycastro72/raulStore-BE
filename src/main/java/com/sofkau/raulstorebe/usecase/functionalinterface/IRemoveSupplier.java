package com.sofkau.raulstorebe.usecase.functionalinterface;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IRemoveSupplier {
    Mono<Void> apply(String id);
}
