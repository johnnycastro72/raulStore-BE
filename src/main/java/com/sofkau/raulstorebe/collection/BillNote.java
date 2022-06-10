package com.sofkau.raulstorebe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "billnotes")
public class BillNote {
    @Id
    private String id;

    private String billId;

    private LocalDateTime billDate;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Sales person name can't be blank")
    private String salesPerson;

    private Double billTotal;

    private List<BillItem> items;
}
