package com.abhicodes.reactivecrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private String prodId;
    private String name;
    private int qty;
    private double price;
}
