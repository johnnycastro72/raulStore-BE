package com.sofkau.raulstorebe.usecase.functionalinterface;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IRemoveProductSupplier {
    Mono<Void> apply(String id);
}
