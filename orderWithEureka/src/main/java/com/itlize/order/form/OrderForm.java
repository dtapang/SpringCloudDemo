package com.itlize.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Data
public class OrderForm {


    @NotEmpty(message = "The name is essential")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "The number is essential")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "The address is essential")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid is essential")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "The cart cannot be empety")
    private String items;

}
