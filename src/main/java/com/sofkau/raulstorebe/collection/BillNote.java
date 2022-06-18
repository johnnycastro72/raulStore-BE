package com.sofkau.raulstorebe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "billnotes")
public class BillNote {
    @Id
    private String id;

    @NotBlank(message = "Bill note id can't be blank")
    private String billId;

    @NotBlank(message = "Bill note date can't be blank")
    private LocalDateTime billDate;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Sales person name can't be blank")
    private String salesPerson;

    @Digits(integer = 14, fraction = 2)
    private Double billTotal;

    @NotEmpty(message = "Bill note must have items")
    private List<BillItem> items;
}
