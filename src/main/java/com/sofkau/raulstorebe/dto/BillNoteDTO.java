package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.BillItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillNoteDTO {
    private String id;

    private String billId = UUID.randomUUID().toString().substring(0, 5);

    @NotBlank(message = "Bill note date can't be blank")
    private LocalDateTime billDate;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Sales person name can't be blank")
    private String salesPerson;

    @Digits(integer = 14, fraction = 2)
    private Double billTotal;

    @NotEmpty(message = "Bill note must have items")
    private List<BillItemDTO> items;
}
