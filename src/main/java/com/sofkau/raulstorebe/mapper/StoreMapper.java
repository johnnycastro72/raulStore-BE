package com.sofkau.raulstorebe.mapper;

import com.sofkau.raulstorebe.collection.*;
import com.sofkau.raulstorebe.dto.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.function.Function;


@Component
@EnableWebFlux
@RequiredArgsConstructor
public class StoreMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public Function<ProductSupplier, ProductSupplierDTO> toProductSupplierDTO() {
        return productSupplier ->
                modelMapper.map(productSupplier, ProductSupplierDTO.class);
    }

    public Function<ProductSupplierDTO, ProductSupplier>  toProductSupplier() {
        return productSupplierDTO -> modelMapper.map(productSupplierDTO, ProductSupplier.class);
    }

    public Function<Product, ProductDTO> toProductDTO() {
        return product -> modelMapper.map(product, ProductDTO.class);
    }

    public Function<ProductDTO, Product> toProduct() {
        return productDTO -> modelMapper.map(productDTO, Product.class);
    }

    public Function<BillNote, BillNoteDTO> toBillNoteDTO() {
        return billNote -> modelMapper.map(billNote, BillNoteDTO.class);
    }

    public Function<BillNoteDTO, BillNote> toBillNote() {
        return billNodeDTO -> modelMapper.map(billNodeDTO, BillNote.class);
    }

    public Function<ReceiptNote, ReceiptNoteDTO> toReceiptNoteDTO() {
        return receiptNote -> modelMapper.map(receiptNote, ReceiptNoteDTO.class);
    }

    public Function<ReceiptNoteDTO, ReceiptNote> toReceiptNote() {
        return receiptDTO -> modelMapper.map(receiptDTO, ReceiptNote.class);
    }

    public Function<ReceiptItem, ReceiptItemDTO> toReceiptItemDTO() {
        return receiptItem -> modelMapper.map(receiptItem, ReceiptItemDTO.class);
    }

    public Function<ReceiptItemDTO, ReceiptItem>  toReceiptItem() {
        return receiptItemDTO -> modelMapper.map(receiptItemDTO, ReceiptItem.class);
    }

    public Function<BillItem, BillItemDTO> toBillItemDTO() {
        return billItem -> modelMapper.map(billItem, BillItemDTO.class);
    }

    public Function<BillItemDTO, BillItem> toBillItem() {
        return billItemDTO -> modelMapper.map(billItemDTO, BillItem.class);
    }

}
