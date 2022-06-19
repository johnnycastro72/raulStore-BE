package com.sofkau.raulstorebe.usecase;

import com.sofkau.raulstorebe.dto.ReceiptNoteDTO;
import com.sofkau.raulstorebe.mapper.StoreMapper;
import com.sofkau.raulstorebe.repository.IReceiptNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllReceiptNotesUseCase implements Supplier<Flux<ReceiptNoteDTO>> {

    private final IReceiptNoteRepository iReceiptNoteRepository;
    private final StoreMapper storeMapper;

    @Override
    public Flux<ReceiptNoteDTO> get() {
        return iReceiptNoteRepository.findAll()
                .map(receiptNote -> storeMapper.toReceiptNoteDTO().apply(receiptNote));
    }
}
