package com.itlize.order.service;

import com.itlize.order.dto.OrderDTO;

/**
 * Created by Yang Shu
 * 2017-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
