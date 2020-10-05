package com.itlize.order.enums;

import lombok.Getter;


@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "Paramters are wrong"),
    CART_EMPTY(2, "The cart is empty")

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
