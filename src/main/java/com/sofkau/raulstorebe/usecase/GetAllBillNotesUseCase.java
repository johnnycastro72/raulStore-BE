package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IBillNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllBillNotesUseCase implements Supplier<Flux<BillNoteDTO>> {

    private final IBillNoteRepository iBillNoteRepository;
    private final StoreMapper storeMapper;

    @Override
    public Flux<BillNoteDTO> get() {
        return iBillNoteRepository.findAll()
                .map(billNote -> storeMapper.toBillNoteDTO().apply(billNote));
    }
}
