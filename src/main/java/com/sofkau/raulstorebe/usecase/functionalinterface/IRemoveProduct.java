package com.sofkau.raulstorebe.usecase.functionalinterface;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IRemoveProduct {
    Mono<Void> apply(String id);
}
