package com.sofkau.raulstorebe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receiptnotes")
public class ReceiptNote {
    @Id
    private String id;

    @NotBlank(message = "Receipt note number can't be blank")
    private String receiptNumber;

    @NotEmpty(message = "Receipt note must have product provider")
    private ProductSupplier productSupplier;

    @NotBlank(message = "Bill note date can't be blank")
    private LocalDateTime receiptDate;

    @NotEmpty(message = "Receipt note must have items")
    private List<ReceiptItem> items;
}
