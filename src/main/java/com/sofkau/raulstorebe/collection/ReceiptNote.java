package com.sofkau.raulstorebe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receiptnotes")
public class ReceiptNote {
    @Id
    private String id;

    private String receiptNumber;

    private ProductSupplier productSupplier;

    private LocalDateTime receiptDate;

    private List<ReceiptItem> items;
}
