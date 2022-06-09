package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.ReceiptItem;
import com.sofkau.raulstorebe.collection.Supplier;

import java.time.LocalDateTime;
import java.util.List;

public class ReceiptNoteDTO {
    private String id;

    private String receiptNumber;

    private Supplier supplier;

    private LocalDateTime receiptDate;

    private List<ReceiptItem> items;
}
