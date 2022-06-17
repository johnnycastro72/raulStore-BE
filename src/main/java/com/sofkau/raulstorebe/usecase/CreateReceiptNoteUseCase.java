package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IReceiptNoteRepository;
import com.sofkau.raulstorebe.usecase.functionalinterface.ICreateReceiptNote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateReceiptNoteUseCase implements ICreateReceiptNote {

    private final IReceiptNoteRepository iReceiptNoteRepository;

    private final StoreMapper storeMapper;

    @Override
    public Mono<ReceiptNoteDTO> apply(ReceiptNoteDTO receiptNoteDTO) {
        return iReceiptNoteRepository
                .save(storeMapper.toReceiptNote()
                        .apply(receiptNoteDTO))
                .map(receiptNote ->storeMapper
                    .toReceiptNoteDTO().apply(receiptNote));
    };

}
