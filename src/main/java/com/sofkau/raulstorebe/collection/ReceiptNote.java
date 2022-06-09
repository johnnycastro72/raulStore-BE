package com.sofkau.raulstorebe.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "receiptnotes")
public class ReceiptNote {
    @Id
    private String id;

    private String receiptNumber = UUID.randomUUID().toString().substring(0, 5);

    private Supplier supplier;

    private LocalDateTime receiptDate;

    private List<ReceiptItem> items;
}
