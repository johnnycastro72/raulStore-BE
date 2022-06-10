package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.ReceiptItem;
import com.sofkau.raulstorebe.collection.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptNoteDTO {
    private String id;

    private String receiptNumber = UUID.randomUUID().toString().substring(0, 5);

    private ProductSupplier productSupplier;

    private LocalDateTime receiptDate;

    private List<ReceiptItemDTO> items;
}
