package com.itlize.order.enums;

import lombok.Getter;


@Getter
public enum PayStatusEnum {
    WAIT(0, "wait for the payment"),
    SUCCESS(1, "payment has placed"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
