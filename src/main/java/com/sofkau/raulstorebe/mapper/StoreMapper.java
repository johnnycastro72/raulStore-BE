package com.sofkau.raulstorebe.mapper;

import com.sofkau.raulstorebe.collection.*;
import com.sofkau.raulstorebe.dto.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;


@Component
@EnableWebFlux
@RequiredArgsConstructor
public class StoreMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public SupplierDTO toCategoryDTO(Supplier supplier) {
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public static Supplier toCollection(SupplierDTO dto) {
        return modelMapper.map(dto, Supplier.class);
    }

    public ProductDTO toProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product toCollection(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    public BillNoteDTO toBillNoteDTO(BillNote billNote) {
        return modelMapper.map(billNote, BillNoteDTO.class);
    }

    public static BillNote toCollection(BillNoteDTO dto) {
        return modelMapper.map(dto, BillNote.class);
    }

    public ReceiptNoteDTO toReceiptNoteDTO(ReceiptNote receiptNote) {
        return modelMapper.map(receiptNote, ReceiptNoteDTO.class);
    }

    public static ReceiptNote toCollection(ReceiptNoteDTO dto) {
        return modelMapper.map(dto, ReceiptNote.class);
    }

    public ReceiptItemDTO toReceiptItemDTO(ReceiptItem receiptItem) {
        return modelMapper.map(receiptItem, ReceiptItemDTO.class);
    }

    public static ReceiptItem toCollection(ReceiptItemDTO dto) {
        return modelMapper.map(dto, ReceiptItem.class);
    }

    public BillItemDTO toBillItemDTO(BillItem billItem) {
        return modelMapper.map(billItem, BillItemDTO.class);
    }

    public static BillItem toCollection(BillItemDTO dto) {
        return modelMapper.map(dto, BillItem.class);
    }

}
