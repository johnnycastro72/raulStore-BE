package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.BillItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillNoteDTO {
    private String id;

    private String billId = UUID.randomUUID().toString().substring(0, 5);

    private LocalDateTime billDate;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Sales person name can't be blank")
    private String salesPerson;

    private Double billTotal;

    private List<BillItemDTO> items;
}
