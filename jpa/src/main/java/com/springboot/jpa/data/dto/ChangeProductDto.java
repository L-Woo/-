package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeProductDto {

    private Long number;
    private String name;

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
