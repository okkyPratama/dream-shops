package com.dailycodework.dream_shops.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long itemid;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
