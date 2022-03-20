package com.appsdeveloperblog.estore.ProductsService.core.event;

import lombok.Data;

import java.math.BigDecimal;

/** naming rule -> <Noun><PerformedAction> Event */

@Data
public class ProductCreatedEvent {

    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
