package com.sofkau.raulstorebe.dto;

import com.sofkau.raulstorebe.collection.BillItem;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class BillNoteDTO {
    private String id;

    private String billId;

    private LocalDateTime billDate;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Sales person name can't be blank")
    private String salesPerson;

    private List<BillItem> items;
}
