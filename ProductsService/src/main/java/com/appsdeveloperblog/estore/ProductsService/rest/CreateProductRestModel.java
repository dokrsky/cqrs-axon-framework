package com.appsdeveloperblog.estore.ProductsService.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    private final String title;
    private final BigDecimal price;
    private final Integer quantity;

}
