package com.springboot.test.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class ProductDto {

    private String name;
    private int price;
    private int stock;

}
