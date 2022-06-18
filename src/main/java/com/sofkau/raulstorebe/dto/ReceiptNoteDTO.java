package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptNoteDTO {
    private String id;

    private String receiptNumber = UUID.randomUUID().toString().substring(0, 5);

    @NotEmpty(message = "Receipt note must have product provider")
    private ProductSupplier productSupplier;

    @NotBlank(message = "Bill note date can't be blank")
    private LocalDateTime receiptDate;

    @NotEmpty(message = "Receipt note must have items")
    private List<ReceiptItemDTO> items;
}
