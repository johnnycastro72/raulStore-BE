package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.BillNoteDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IBillNoteRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateBillNote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateBillNoteUseCase implements ICreateBillNote {
    private final IBillNoteRepository iBillNoteRepository;

    private final StoreMapper storeMapper;

    @Override
    public Mono<BillNoteDTO> apply(BillNoteDTO billNoteDTO) {
        return iBillNoteRepository
                .save(storeMapper.toBillNote()
                        .apply(billNoteDTO))
                .map(billNote -> storeMapper
                        .toBillNoteDTO().apply(billNote));
    }
}
