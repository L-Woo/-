package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;


}
