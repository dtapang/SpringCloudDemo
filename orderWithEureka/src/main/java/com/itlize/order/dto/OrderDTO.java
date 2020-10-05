package com.itlize.order.dto;

import com.itlize.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Yang Shu
 * 2019-12-10 16:42
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;


    private String buyerAddress;


    private String buyerOpenid;


    private BigDecimal orderAmount;


    private Integer orderStatus;


    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
