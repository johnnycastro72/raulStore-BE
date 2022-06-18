package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IBillNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetBillByIdUseCase implements Function<String, Mono<BillNoteDTO>> {

    private final IBillNoteRepository iBillNoteRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<BillNoteDTO> apply(String id) {
        return iBillNoteRepository.findByBillId(id)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getStackTrace());
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(() -> new NoSuchElementException()))
                .map(billNote -> storeMapper.toBillNoteDTO().apply(billNote));
    }
}
