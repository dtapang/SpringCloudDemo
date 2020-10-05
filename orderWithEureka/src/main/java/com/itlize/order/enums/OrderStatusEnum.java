package com.itlize.order.enums;

import lombok.Getter;


@Getter
public enum OrderStatusEnum {
    NEW(0, "new"),
    FINISHED(1, "Finished"),
    CANCEL(2, "Cancled"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
