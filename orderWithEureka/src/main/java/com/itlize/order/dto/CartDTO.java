package com.itlize.order.dto;

import lombok.Data;

/**
 * Created by yang Shu
 * 2019-12-10 22:36
 */
@Data
public class CartDTO {

    private String productId;


    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
