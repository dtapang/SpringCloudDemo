package com.itlize.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Data
public class OrderForm {


    @NotEmpty(message = "The name is essential")
    private String name;

    /**
     * Buyer phone number
     */
    @NotEmpty(message = "The number is essential")
    private String phone;

    /**
     * Buyer Address
     */
    @NotEmpty(message = "The address is essential")
    private String address;

    /**
     * buyer openid
     */
    @NotEmpty(message = "openid is essential")
    private String openid;

    /**
     * cart
     */
    @NotEmpty(message = "The cart cannot be empety")
    private String items;

}
