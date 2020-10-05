package com.itlize.product.enums;

import lombok.Getter;

/**
 * Created by yang shu
 * 2017-12-10 23:00
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "product is not exist"),
    PRODUCT_STOCK_ERROR(2, "inventory error"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
