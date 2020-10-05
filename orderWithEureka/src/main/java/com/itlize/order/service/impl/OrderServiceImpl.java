package com.itlize.order.service.impl;

import com.itlize.order.utils.KeyUtil;
import com.itlize.order.dataobject.OrderMaster;
import com.itlize.order.dto.OrderDTO;
import com.itlize.order.enums.OrderStatusEnum;
import com.itlize.order.enums.PayStatusEnum;
import com.itlize.order.repository.OrderDetailRepository;
import com.itlize.order.repository.OrderMasterRepository;
import com.itlize.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Yang Shu
 * 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO query product information (call product service)
        //TODO calculates the total price
        //TODO deduction of inventory (call goods and services)

        //Order storage
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

}
